/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.test;

import cth.webapp.duogames.duogames.model.memory.Memory;
import cth.webapp.duogames.duogames.model.memory.Pair;
import cth.webapp.duogames.duogames.services.DuoApi;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author nicla
 */
public class MemoryTest {
     DuoApi api = new DuoApi("llusx", "NO_PASSWORD_NEEDED");
     
    @Test
    public void generatePairs(){
        Memory m = new Memory(api.getDictionaryOfKnownWords("en", api.getCurrentLanguage()), 16);
        
        List<Pair> pairs = m.generatePairs();
        assertTrue(pairs.size() == 16);
        
        for(int i = 0; i < pairs.size(); i++){
            for(int j = 0; j < pairs.size(); j++){
                if(i == j){
                    assertTrue(pairs.get(i).equals(pairs.get(j)));
                }
                else{
                    assertFalse(pairs.get(i).equals(pairs.get(j)));
                }
        }
        }
        
        
        
        //testing non duplicated pairs
        
        
    }
    
    @Test
    public void testEquals(){
        Pair p1 = new Pair("a", "b");
        Pair p2 = new Pair("a", "a");
        Pair p3 = new Pair("åäö", "aaö");
        Pair p4 = new Pair("TEST", "test");
        
        assertTrue(p1.equals(p1));
        assertTrue(p2.equals(p2));
        assertTrue(p3.equals(p3));
        assertTrue(p4.equals(p4));
        
        assertFalse(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        
        assertFalse(p2.equals(p1));
        assertFalse(p2.equals(p3));
        assertFalse(p2.equals(p4));
        
        assertFalse(p3.equals(p1));
        assertFalse(p3.equals(p2));
        assertFalse(p3.equals(p4));
        
        assertFalse(p4.equals(p1));
        assertFalse(p4.equals(p2));
        assertFalse(p4.equals(p3));
    }
}
