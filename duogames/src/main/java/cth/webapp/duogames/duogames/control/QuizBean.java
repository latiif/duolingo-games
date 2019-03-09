/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.database.entity.GameSession;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.listening.WhatDidYouSayQuiz;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author latiif
 */
@Named(value="quiz")
@SessionScoped
public class QuizBean extends GameBean implements Serializable {
    
    @Inject
    private UserBean userBean;
    
    @Inject
    private ScoreBean scorebean;
    
    @Inject
    private QuizData quizData;
    
    @EJB
    private GameDAO gameDAO;
    
    private List<IQuestion> quiz;
    private String gameType;
    
    @Getter
    @Setter
    private int totalQuestions;
    
    @Getter
    @Setter
    private int currQuestion;
    
    @Getter
    private int nrCorrect;
    
    @Getter
    private String time;
    
    private Timestamp startTime;
    private Timestamp endTime;
    
    @Getter
    private int score;
    

    public List<IQuestion> getQuizInformation(UserBean ub) {
        
        
        if (quiz == null) {
            quiz = startGame();
        }
        
        return quiz;
    }

    @Override
    public List<IQuestion> startGame() {
       
        Map<String, List<String>> dict = userBean.getApi().getDictionaryOfKnownWords("en", userBean.getApi().getCurrentLanguage());

        currQuestion = 0;
        nrCorrect = 0;
        totalQuestions = 10;
        startTime = new Timestamp(System.currentTimeMillis());
        return new Quiz(dict, 10, 3).generateQuestions();
            
    }
    
    @Override
    public void resetGame() {
        quiz = null;
        redirect("/duogames/play.xhtml");
    }
    
    public void validate(){
        if (quiz.get(currQuestion).check(quizData.getAnswer()))
        {
            FacesMessages.info("Correct!");
            nrCorrect++;
            currQuestion++;
            if(currQuestion == 10){
                endGame();
            }
        }
        else{
            FacesMessages.error("Wrong");
            currQuestion++;
            if(currQuestion == 10){
                endGame();
            } 
        }
       
    }

    private void addToDatabase(long gameTime) {
        GameSession game = new GameSession(BigInteger.valueOf(gameTime), score, "quiz", userBean.getUser());
        gameDAO.add(game);
    }

    @Override
    public void endGame() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime());
        long seconds = diff / 1000L;
        time = TimeFormatter.format(seconds);
        score = ScoreCalculator.calculateScore(nrCorrect, diff);
        scorebean.setGamebean(this);
        addToDatabase(seconds);
        redirect("/duogames/score.xhtml");
    }

    

}
