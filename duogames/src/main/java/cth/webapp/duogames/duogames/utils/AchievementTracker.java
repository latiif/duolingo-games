/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.utils;

import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.database.dao.GameDAO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author stina
 */
@SessionScoped
public class AchievementTracker implements Serializable {
    
    @EJB
    GameDAO gameDAO;
    @Inject
    UserBean userBean;
    
    private static AchievementTracker INSTANCE = null;
    private Map<String, String> achievements;
    
    @PostConstruct
    private void setup() {
        achievements = new HashMap<>();
        
        if(gameDAO.findQuickestTime().intValue() < 20){
            achievements.put("quick", "res/bolt.png");
        }
        if(gameDAO.findSingleHighestScore() >= 1500){
            achievements.put("star", "res/star.png");
        }
        if(gameDAO.findTotalGames() >= 100){
            achievements.put("gold", "res/gold.png");
        }
        if(userBean.getUser().getId() < 100){
            achievements.put("early", "res/shoot.png");
        }
    }
    
    public static AchievementTracker getInstance() {
        if (INSTANCE == null){
            INSTANCE = new AchievementTracker();
        }
        return INSTANCE;
    }
    
    public Map<String, String> getAchievements(){
        return achievements;
    }
    
}
