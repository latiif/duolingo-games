/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model.memory;

import cth.webapp.duogames.duogames.model.Game;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.quiz.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author nicla
 */
public class Memory extends Game {

    private Map<String, List<String>> mDict;
    private int cards;

    public Memory(Map<String, List<String>> dict, int cards) {
        this.mDict = dict;
        this.cards = cards;
    }

//    public List<String> generatePair(){
//       List<String> cards = new ArrayList<>();
//        
//        return cards;
//    }
    public List<Pair> generatePairs() {
        List<Pair> result = new LinkedList<>();

        Map<String, List<String>> cleanDict = cleanDict(mDict);

        List<String> words = new LinkedList<>(cleanDict.keySet());
        List<String> allTranslations = mDict.values().stream()
                .flatMap((name) -> name.stream())
                .collect(Collectors.toList());

        int count = 0;
        while (!words.isEmpty() && count < cards) {

            int random = (int) (Math.random() * words.size());
            String tWord = words.get(random);
            List<String> tRight = cleanDict.get(tWord);
            result.add(new Pair(tWord, tRight.get(0)));

            words.remove(random);
            count++;
        }
        Collections.shuffle(result);
        return result;
    }

}
