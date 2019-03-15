/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.control.QuizBean;
import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.services.DuoApi;
import java.util.List;
import javax.ejb.Init;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author nicla
 */
public class QuizTest {
    private QuizBean quiz = new QuizBean();
     List<IQuestion> quizList;
     UserBean user;
     DuoApi api = new DuoApi("llusx", "NO_PASSWORD_NEEDED");
     
    @Init
    public void initTest(){
        user = new UserBean();
        user.signin();
        user.setApi(api);
        
       quizList = quiz.initQuiz(user);
    }
    @Test 
    public void getDictionary(){
        
        quiz.validate();
        
        System.out.println(api.getDictionaryOfKnownWords("en", api.getCurrentLanguage()));
        
    }

    @Test
    public void testValidate(){
        

    }

}
