package cth.webapp.duogames.duogames.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Game {

    int id;
    boolean isFinished;
    Map<String, List<String>> dict;

    protected Map<String, List<String>> cleanDict(Map<String, List<String>> dict) {
        Map<String, List<String>> result = new HashMap<>();
        for (String key : dict.keySet()) {
            List<String> translations = dict.get(key);
            if (translations == null || translations.isEmpty()) {
                continue;
            }
            result.put(key, translations);
        }
        return result;
    }
}
