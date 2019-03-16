package cth.webapp.duogames.duogames.model.memory;

import cth.webapp.duogames.duogames.model.Game;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Memory extends Game {

    private Map<String, List<String>> mDict;
    private int pairs;

    public Memory(Map<String, List<String>> dict, int pairs) {
        this.mDict = dict;
        this.pairs = pairs;
    }

    /***
     * Creates a list of word pairs, which is one word and its translation.
     * @return 
     */
    public List<Pair> generatePairs() {
        List<Pair> result = new LinkedList<>();
        Map<String, List<String>> cleanDict = cleanDict(mDict);
        List<String> words = new LinkedList<>(cleanDict.keySet());
        int count = 0;
        while (!words.isEmpty() && count < pairs) {
            int random = (int) (Math.random() * words.size());
            String tWord = words.get(random);
            List<String> tRight = cleanDict.get(tWord);
            result.add(new Pair(tWord, tRight.get(0)));
            words.remove(random);
            count++;
        }
        return result;
    }

}
