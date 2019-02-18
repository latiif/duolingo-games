/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model.quiz;

/**
 *
 * @author nicla
 */
class Question {
    String quest;
    String from;
    String[] answers;
    String rAnswer;
    String[] wAnswer;
    
    
    public Question(String from, String rAnswer, String[] wAnswers){
        this.from = from;
        this.rAnswer = rAnswer;
        quest = "Translate " + from;
        this.wAnswer = wAnswer;
        answers = new String[4];
        answers[0] = rAnswer;
        for(int i = 1; i <= wAnswer.length; i++){
            answers[i] = wAnswers[i-1];
        }
        
        
        
        
    }
}
