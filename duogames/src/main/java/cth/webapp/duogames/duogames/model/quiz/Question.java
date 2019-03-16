package cth.webapp.duogames.duogames.model.quiz;

import cth.webapp.duogames.duogames.model.IQuestion;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import lombok.Getter;

public class Question implements IQuestion {

    private String word;
    @Getter
    private List<String> wrongAnswers;
    @Getter
    private String rightAnswer;

    public List<String> getOptions() {
        List<String> options = new LinkedList<>(wrongAnswers);
        options.add(rightAnswer);
        Collections.shuffle(options);
        return options;
    }

    public Question(String word, List<String> wrongAnswers, String rightAnswer) {
        this.word = word;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public boolean check(String answer) {
        return rightAnswer.toLowerCase().equals(answer.toLowerCase());
    }

    public String getWord() {
        return word;
    }

}
