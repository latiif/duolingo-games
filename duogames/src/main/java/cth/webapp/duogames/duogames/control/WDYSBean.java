/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.entity.Gamesession;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.listening.WhatDidYouSayQuiz;
import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author nicla
 */
@Named(value="wdys")
@SessionScoped
public class WDYSBean extends GameBean implements Serializable {
    @Getter
    @Setter
    private String answer;
    
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
    
     private List<IQuestion> quiz;
    
    @Override
    public List<IQuestion> startGame() {
         Map<String, List<String>> dict = super.getUserBean().getApi().getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());

        currQuestion = 0;
        nrCorrect = 0;
        totalQuestions = 10;
        startTime = new Timestamp(System.currentTimeMillis());

        
       return new WhatDidYouSayQuiz(dict, 10).generateQuestions(super.getUserBean().getApi());
    }
    public void resetQuiz() {
        quiz = null;
        redirect("/duogames/play.xhtml");
    }
    
    public void validate(){
        if (quiz.get(currQuestion).check(super.getQuizData().getAnswer()))
        {
            FacesMessages.info("Correct!");
            nrCorrect++;
            currQuestion++;
            if(currQuestion == 10){
                endQuiz();
            }
            answer = "";
        }
        else{
            FacesMessages.error("Wrong");
            currQuestion++;
            if(currQuestion == 10){
                endQuiz();
            } 
            answer = "";
        }
       
    }

    private void redirect(String url) {
        try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
        }

    private void addToDatabase(long gameTime) {
        Gamesession game = new Gamesession(true, BigInteger.valueOf(gameTime), score, super.getUserBean().getUser());
        super.getGameDAO().add(game);
    }

    private void endQuiz() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime());
        long seconds = diff / 1000L;
        time = TimeFormatter.format(seconds);
        score = ScoreCalculator.calculateScore(nrCorrect, diff);
        addToDatabase(seconds);
        redirect("/duogames/score.xhtml");
    }
    
    
    
    
}
