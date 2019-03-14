/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.control.QuizBean;
import cth.webapp.duogames.duogames.services.DuoApi;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author nicla
 */
public class QuizTest {
    private QuizBean quiz = new QuizBean();
    
    @Test 
    public void getDictionary(){
        DuoApi api = new DuoApi("llusx", "NO_PASSWORD_NEEDED");
        
        System.out.println(api.getDictionaryOfKnownWords("en", api.getCurrentLanguage()));
        
    }

    @Test
    public void testValidate(){
        

    }

}
