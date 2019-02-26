/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model.quiz;

/**
 *
 * @author nicla, latiif
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question {

    private String word;
    private List<String> wrongAnswers;
    private String rightAnswer;

    public List<String> getOptions() {
        List<String> options = new LinkedList<>(wrongAnswers);
        options.add(rightAnswer);

        Collections.shuffle(options);

        return options;
    }

    public Question(String word, List<String> wrongAnswers, String rightAnswer) {
        this.word = word;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    public boolean check(String answer) {
        return rightAnswer.toLowerCase().equals(answer.toLowerCase());
    }

    public String getWord() {
        return word;
    }

}
