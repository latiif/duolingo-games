/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author stina
 */
@RequestScoped
@Named
public class QuizData implements Serializable {
    
    @Getter
    private String answer = "";
    
    public void setAnswer(String answer) {
        System.out.println("Setting answer:" + answer);
        this.answer = answer;
    }
}
