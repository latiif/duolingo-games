/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import static cth.webapp.duogames.duogames.utils.ScoreCalculator.calculateScore;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;



/**
 *
 * @author nicla
 */
public class UtilsTest {
    private ScoreCalculator score = new ScoreCalculator();
    
    
//Unit test for scorecalculator
    @Test
    public void testScore(){
        int corr = 5;
        long time = 1000;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));
        
        corr = -5;
        time = 1000;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));
        
        
        corr = 5;
        time = -1000;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));
        
        corr = -5;
        time = -1000;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));
        
        corr = 0;
        time = 1000;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));
        
        corr = 5;
        time = 0;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        assertNotEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore((int)time, corr));
        
        corr = 0;
        time = 0;

        assertEquals(corr * 100 + Math.max((90000 - time) / 100, 0), calculateScore(corr, time));
        
        

    }
    
    @Test
    public void testTime(){
        
        assertEquals("00:00:01", TimeFormatter.format(1));
        assertEquals("00:01:00", TimeFormatter.format(60));
        assertEquals("00:01:12", TimeFormatter.format(72));
        assertEquals("01:01:00", TimeFormatter.format(3660));
        assertEquals("99:59:59", TimeFormatter.format(359999));
        assertEquals("100:00:00", TimeFormatter.format(360000));
        assertEquals("1000:00:00", TimeFormatter.format(3600000));
        assertEquals("00:00:00", TimeFormatter.format(0));
        
    }
    
    

}
