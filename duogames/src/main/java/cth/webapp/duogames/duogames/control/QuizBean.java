/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.quiz.Question;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author latiif
 */
@Named(value="quiz")
@SessionScoped
public class QuizBean implements Serializable {

   
    
    private List<Question> quiz;
    
    @Getter
    @Setter
    private String answer;
    
    private UserBean userBean;

    public List<Question> getQuizInformation(UserBean ub) {
        
        
        
        if (quiz == null) {
            userBean = ub;
            quiz = startQuiz();
        }

        return quiz;
    }

    private List<Question> startQuiz() {
       

        Map<String, List<String>> dict = userBean.getApi().getDictionaryOfKnownWords("en", userBean.getApi().getCurrentLanguage());

        return new Quiz(dict, 10, 3).generateQuestions();

    }
}
