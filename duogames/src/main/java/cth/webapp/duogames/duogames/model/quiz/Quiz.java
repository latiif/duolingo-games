/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model.quiz;

import cth.webapp.duogames.duogames.model.Game;
import cth.webapp.duogames.duogames.database.entity.User;
import java.util.List;

/**
 *
 * @author nicla
 */
public class Quiz extends Game {

    Question[] questions;

    public Quiz() {
        questions = new Question[10];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = generetQuestion();
        }

    }

    private Question generetQuestion() {
        //TODO testing implementation
        String[] ans = {"dog", "cat", "bye"};
        return new Question("hej", "hi", ans);
    }
}
