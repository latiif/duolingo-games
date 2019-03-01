/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.database.entity.Gamesession;
import cth.webapp.duogames.duogames.model.quiz.Question;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
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
public class QuizBean implements Serializable {
    
    @Inject
    private UserBean userBean;
    
    @EJB
    private GameDAO gameDAO;
    
    private List<Question> quiz;
    
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
    

    public List<Question> getQuizInformation(UserBean ub) {
        
        if (quiz == null) {
            quiz = startQuiz();
        }
        
        return quiz;
    }

    public List<Question> startQuiz() {
       
        Map<String, List<String>> dict = userBean.getApi().getDictionaryOfKnownWords("en", userBean.getApi().getCurrentLanguage());

        currQuestion = 0;
        nrCorrect = 0;
        totalQuestions = 10;
        startTime = new Timestamp(System.currentTimeMillis());
        
        return new Quiz(dict, 10, 3).generateQuestions();

    }
    
    public void resetQuiz() {
        quiz = null;
        redirect("/duogames/play.xhtml");
    }
    
    public void validate(){
        if (quiz.get(currQuestion).check(answer))
        {
            FacesMessages.info("Correct!");
            nrCorrect++;
            currQuestion++;
            if(currQuestion == 10){
                endQuiz();
            }            
        }
        else{
            FacesMessages.error("Wrong");
            currQuestion++;
            if(currQuestion == 10){
                endQuiz();
            } 
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
        score = nrCorrect * (int) gameTime;
        Gamesession game = new Gamesession(true, BigInteger.valueOf(gameTime), score, userBean.getUser());
        gameDAO.add(game);
    }

    private void endQuiz() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime()) / 1000L;
        time = TimeFormatter.format(diff);
        addToDatabase(diff);
        redirect("/duogames/score.xhtml");
    }
}
