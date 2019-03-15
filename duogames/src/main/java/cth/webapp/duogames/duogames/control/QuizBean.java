/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.utils.FacesMessages;
import org.ocpsoft.common.util.Strings;

/**
 *
 * @author latiif
 */
@Named(value="quiz")
@SessionScoped
public class QuizBean extends GameBean implements Serializable {
    
    
    @Inject
    private ScoreBean scorebean;
    
    @Inject
    @Setter
    private QuizData quizData;
    
    
    @Getter
    private final String type = "quiz";
    
    @Getter
    @Setter
    private String gameid;
    
    
    
    private Timestamp startTime;
    private Timestamp endTime;
    

    public List<IQuestion> initQuiz(UserBean ub) {
        if (quizData.getIQuiz() == null) {
            quizData.setIQuiz(startGame());
        }
        return quizData.getIQuiz();
    }

    @Override
    public List<IQuestion> startGame() {
        Map<String, List<String>> dict = super.getUserBean().getApi().getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());
        quizData.setCurrQuestion(0);
        quizData.setTotalQuestions(10);
        quizData.setNrCorrect(0);
        quizData.setAnswer("");
        startTime = new Timestamp(System.currentTimeMillis());
        return new Quiz(dict, 10, 3).generateQuestions();
    }
    
    @Override
    public void resetGame() {

        quizData.setIQuiz(null);
        gameid = "";

        redirect("/duogames/play.xhtml");
    }
    
    
}
