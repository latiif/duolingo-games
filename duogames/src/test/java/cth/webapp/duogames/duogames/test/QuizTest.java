/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.control.QuizBean;
import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.quiz.Question;
import cth.webapp.duogames.duogames.services.DuoApi;
import cth.webapp.duogames.duogames.view.QuizData;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Init;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author nicla
 */
public class QuizTest {
    private QuizBean quiz = new QuizBean();
     DuoApi api = new DuoApi("llusx", "NO_PASSWORD_NEEDED");
     
    @Init
    public void initTest(){

    }
    @Test 
    public void getDictionary(){
        int x = 0;
        List<String> wrong = new ArrayList<>();
        wrong.add("a");
        wrong.add("b");
        wrong.add("c");
        
        

        Question quizl = new Question("test",wrong, "test");
        assertTrue(quizl.check("test"));
        assertFalse(quizl.check("a"));
        assertFalse(quizl.check("b"));
        assertFalse(quizl.check("c"));
        assertFalse(quizl.check("d"));
        
        
        quizl = new Question("test",wrong, "töst");
        assertTrue(quizl.check("töst"));
        assertFalse(quizl.check("test"));
        assertFalse(quizl.check("b"));
        assertFalse(quizl.check("c"));
        assertFalse(quizl.check("d"));
        
        quizl = new Question("test",wrong, "b");
        assertTrue(quizl.check("b"));
        assertFalse(quizl.check("test"));
        assertFalse(quizl.check("a"));
        assertFalse(quizl.check("c"));
        assertFalse(quizl.check("d"));
        
        
        //System.out.println(api.getDictionaryOfKnownWords("en", api.getCurrentLanguage()));
        
    }

    @Test
    public void testValidate(){
        

    }

}
