package cth.webapp.duogames.duogames.model.memory;

import cth.webapp.duogames.duogames.model.IQuestion;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;

public class Pair implements IQuestion {

    @Getter
    private final String word;
    @Getter
    private final String answer;

//    public List<String> getOptions() {
//        List<String> options = new LinkedList<>(wrongAnswers);
//        options.add(rightAnswer);
//
//        Collections.shuffle(options);
//
//        return options;
//    }

    public Pair(String word, String answer) {
        this.word = word;
        this.answer = answer;
    }

    @Override
    public boolean check(String answer) {
        return answer.toLowerCase().equals(word.toLowerCase());
    }

}
