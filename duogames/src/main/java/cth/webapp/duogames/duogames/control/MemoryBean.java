/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.model.memory.Memory;
import cth.webapp.duogames.duogames.model.memory.Pair;
import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
    @Inject
    private ScoreBean scorebean;
    
    @Getter
    private List<String> quiz;
        
    @Getter
    private String time;
    
    private Timestamp startTime;
    private Timestamp endTime;
    
    @Getter
    private int score;

    @Getter
    final private int nrOfPairs = 6;
    final private String type = "pair";
    
    @Getter
    private List<Pair> pairs;
    @Getter
    @Setter
    private String word = "";
    @Getter
    @Setter
    private String answer = "";
    @Getter
    private boolean result;
    
    
    public List<String> getQuizInformation(UserBean ub) {
        
        if (quiz == null) {
            quiz = startGame();
        }
        
        return quiz;
    }
    
    @Override
    public List<String> startGame(){
        Map<String, List<String>> dict = super.getUserBean().getApi().getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());

        startTime = new Timestamp(System.currentTimeMillis());
        pairs = new Memory(dict, 6).generatePairs();
        quiz = new ArrayList<>();
        
        pairs.forEach(p -> 
                {
                    quiz.add(p.getWord());
                    quiz.add(p.getAnswer());
                });
        Collections.shuffle(quiz);
        return quiz;
    }

    @Override
    public void endGame() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime());
        long seconds = diff / 1000L;
        time = TimeFormatter.format(seconds);
        score = ScoreCalculator.calculateScore(nrOfPairs * 2, diff);
        scorebean.setGamebean(this);
        addToDatabase(score, seconds, type);
        redirect("/duogames/score.xhtml");
    }

    @Override
    public void resetGame() {
        quiz = null;
        redirect("/duogames/play.xhtml");
    }
    
    public void checkPair(){
        FacesContext context = FacesContext.getCurrentInstance();
        word = context.getExternalContext().getRequestParameterMap().get("word");
        answer = context.getExternalContext().getRequestParameterMap().get("answer");
        for(Pair oldPair : pairs){
            if(oldPair.getWord().equalsIgnoreCase(word)){
                Pair p = new Pair(word, answer);
                result = oldPair.equals(p);
                return;
            } else if(oldPair.getAnswer().equalsIgnoreCase(answer)){
                Pair p = new Pair(word, answer);
                result = oldPair.equals(p);
                return;
            } else if (oldPair.getAnswer().equalsIgnoreCase(word)) {
                Pair p = new Pair(answer, word);
                result = oldPair.equals(p);
                return;
            } else if (oldPair.getWord().equalsIgnoreCase(answer)) {
                Pair p = new Pair(answer, word);
                result = oldPair.equals(p);
                return;
            }
        }
    }
}