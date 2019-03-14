/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model.quiz;

import cth.webapp.duogames.duogames.model.Game;
import cth.webapp.duogames.duogames.model.IQuestion;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author nicla, latiif
 */
public class Quiz extends Game {

    private Map<String, List<String>> mDict;
    private int quizLength;
    private int nChoices;

    public Quiz(Map<String, List<String>> dict, int quizLength, int nChoices) {
        this.mDict = dict;
        this.quizLength = quizLength;
        this.nChoices = nChoices;
    }

    private List<String> generateWrongAnswers(List<String> allAnswers, List<String> rightAnswers) {
        List<String> result = new LinkedList<>();

        Collections.shuffle(allAnswers);
        final int N = nChoices;

        result = allAnswers
                .stream()
                .limit(N)
                .filter(s -> !(rightAnswers.contains(s.toLowerCase())))
                .collect(Collectors.toList());

        return result;
    }

    public List<IQuestion> generateQuestions() {
        List<IQuestion> result = new LinkedList<>();

        Map<String, List<String>> cleanDict = cleanDict(mDict);

        List<String> words = new LinkedList<>(cleanDict.keySet());
        List<String> allTranslations = mDict.values().stream()
                .flatMap((name) -> name.stream())
                .collect(Collectors.toList());

        int count = 0;
        while (!words.isEmpty() && count < quizLength) {

            int random = (int) (Math.random() * words.size());
            String tWord = words.get(random);
            List<String> tRight = cleanDict.get(tWord);
            result.add(new Question(tWord, generateWrongAnswers(allTranslations, tRight), tRight.get(0)));

            words.remove(random);
            count++;
        }

        return result;
    }

}
