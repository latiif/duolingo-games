/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import static cth.webapp.duogames.duogames.utils.ScoreCalculator.calculateScore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;



/**
 *
 * @author nicla
 */
public class UtilsTest {
    private ScoreCalculator score = new ScoreCalculator();
    
    

    @Test
    public void testScore(){
        int corr = 5;
        long time = 1000;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));

    }
    
    @Test
    public void testTime(){
        assertEquals(1,1);
    }
    
    

}
