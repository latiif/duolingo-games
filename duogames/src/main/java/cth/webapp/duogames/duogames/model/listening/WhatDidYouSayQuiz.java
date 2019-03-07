/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model.listening;

import cth.webapp.duogames.duogames.model.Game;
import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.services.DuoApi;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author latiif
 */
public class WhatDidYouSayQuiz extends Game {

    private Map<String, List<String>> mDict;

    private int mQuizLength;

    public WhatDidYouSayQuiz(Map<String, List<String>> dict, int nrQuestions) {
        this.mDict = cleanDict(dict);
        this.mQuizLength = nrQuestions;
    }

    public List<IQuestion> generateQuestions(DuoApi api) {
        List<IQuestion> result = new LinkedList<>();

        AudioMapper am = AudioMapper.getInstance();
        
        String currLang = api.getCurrentLanguage();
        
        List<String> words = mDict
                .keySet()
                .stream()
                .filter(w -> !w.contains(" "))
                .limit(this.mQuizLength)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        Collections.shuffle(words);

        return words.stream()
               
                .map(w -> new ListeningQuestion(am.getAudioUrl(w, currLang),w))
                .collect(Collectors.toList());
    }
    
}
