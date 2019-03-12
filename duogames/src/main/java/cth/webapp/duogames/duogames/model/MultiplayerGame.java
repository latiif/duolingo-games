/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model;

import cth.webapp.duogames.duogames.view.UserData;
import static java.lang.Math.abs;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author latiif
 */
public class MultiplayerGame {
    private List<String> participants;
    private String id;
    
    private int nrWords;
    private String language;
    
    
    public MultiplayerGame(int nrWords, String language,String creator){
        this.nrWords = nrWords;
        this.language = language;
        participants = new LinkedList<>();
        addParticipant(creator, nrWords, language);
    }
    
    public List<String> getParticipants(){
       return new LinkedList(participants);
    }
    
    public String getId(){return this.id;}
    
    public boolean addParticipant(String uid, int nrWords, String language){
        if (!this.language.toLowerCase().equals(language.toLowerCase())){
            return false;
        }
        
        if (abs(nrWords-this.nrWords)>50){
            return false;
        }
        
        participants.add(uid);
        return true;
    }
    
}
