/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.memory.Memory;
import cth.webapp.duogames.duogames.model.memory.Pair;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author nicla
 */
@Named(value="memory")
@SessionScoped
public class MemoryBean extends GameBean implements Serializable {
    private Memory game;
    private Timestamp startTime;
    
    private List<String> quiz;
    
    public List<String> getQuizInformation(UserBean ub) {
        
        if (quiz == null) {
            quiz = startGame();
        }
        
        return quiz;
    }
    
    @Override
    public List<String> startGame(){
        Map<String, List<String>> dict = super.getUserBean().getApi().getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());

        //currQuestion = 0;
        //nrCorrect = 0;
        //totalQuestions = 10;
        startTime = new Timestamp(System.currentTimeMillis());
        return new Memory(dict, 6).generatePairs();
    }

    @Override
    public void endGame() {
        redirect("/duogames/score.xhtml");
    }

    @Override
    public void resetGame() {
        quiz = null;
        redirect("/duogames/play.xhtml");
    }
}
