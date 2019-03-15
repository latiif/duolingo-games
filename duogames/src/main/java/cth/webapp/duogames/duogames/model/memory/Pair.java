package cth.webapp.duogames.duogames.model.memory;

import cth.webapp.duogames.duogames.model.IQuestion;
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

    public boolean equals(Pair newPair) {
        return (this.answer.equalsIgnoreCase(newPair.getAnswer())
                && this.word.equalsIgnoreCase(newPair.getWord()));
    }

}
