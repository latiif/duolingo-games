/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.listening.WhatDidYouSayQuiz;
import cth.webapp.duogames.duogames.services.DuoApi;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author nicla
 */
public class WDYSTest {
    DuoApi api = new DuoApi("llusx", "NO_PASSWORD_NEEDED");
    
    @Test
    public void testGenerateQuestion(){
         WhatDidYouSayQuiz m = new WhatDidYouSayQuiz(api.getDictionaryOfKnownWords("en", api.getCurrentLanguage()), 16);
        
        List<IQuestion> questions = m.generateQuestions(api);
        assertTrue(questions.size() == 16);
        
        for(int i = 0; i < questions.size(); i++){
            for(int j = 0; j < questions.size(); j++){
                if(i == j){
                    assertTrue(questions.get(i).equals(questions.get(j)));
                }
                else{
                    assertFalse(questions.get(i).equals(questions.get(j)));
                }
        }
    }
}
