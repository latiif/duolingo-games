/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.quiz.Card;
import cth.webapp.duogames.duogames.model.quiz.Memory;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nicla
 */


@Named(value="memory")
@SessionScoped
public class MemoryBean extends GameBean implements Serializable {
    private Memory game;
    
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
    
    List<Card> cards;
    
    public List<Card> getQuizInformation(UserBean ub) {
        
        
        
        if (cards == null) {
            cards = startGame();
        }
        
        return cards;
    }
    
    public List<Card> startGame(){
        game = new Memory();
        Map<String, List<String>> dict = userBean.getApi().getDictionaryOfKnownWords("en", userBean.getApi().getCurrentLanguage());
        currQuestion = 0;
        nrCorrect = 0;
        totalQuestions = 10;
        startTime = new Timestamp(System.currentTimeMillis());
        return game.generatePairs();
    }

    @Override
    public void endGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
