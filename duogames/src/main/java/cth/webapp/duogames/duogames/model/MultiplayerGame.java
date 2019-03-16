package cth.webapp.duogames.duogames.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MultiplayerGame {

    private List<String> participants;
    private Map<String, Integer> scores;
    private String id;
    private int nrWords;
    private String language;

    public MultiplayerGame(int nrWords, String language, String creator) {
        this.nrWords = nrWords;
        this.language = language;
        participants = new LinkedList<>();
        scores = new HashMap<>();
        addParticipant(creator, nrWords, language);
    }

    public List<String> getParticipants() {
        return new LinkedList(participants);
    }

    public void addScore(String player, Integer score) {
        scores.put(player, score);
    }

    public int getRanking(String userid) {
        SortedSet<Integer> values = new TreeSet<>(scores.values());
        int ranking = 1;
        for (Integer value : values) {
            if (scores.getOrDefault(userid, 0) == value) {
                return ranking;
            }
            ranking++;
        }
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public boolean addParticipant(String uid, int nrWords, String language) {
        if (!this.language.toLowerCase().equals(language.toLowerCase())) {
            return false;
        }
        //Take out fair play criteria, for demo
        /*
        if (abs(nrWords-this.nrWords)>50){
            return false;
        }  
         */
        participants.add(uid);
        return true;
    }
}
