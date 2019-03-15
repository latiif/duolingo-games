/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.view;

import cth.webapp.duogames.duogames.model.IQuestion;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author stina
 */
@SessionScoped
@Named(value = "quizData")
public class QuizData implements Serializable {

    @Setter
    @Getter
    private String answer = "";

    @Getter
    @Setter
    private int totalQuestions;

    @Getter
    @Setter
    private int currQuestion;

    @Getter
    @Setter
    private int nrCorrect;

    @Getter
    @Setter
    private String time;

    @Getter
    @Setter
    private int score;

    @Getter
    @Setter
    private List<String> quiz;
    @Getter
    @Setter
    private List<IQuestion> iQuiz;

}
