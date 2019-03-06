/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.view;

import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.database.entity.Gamesession;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author stina
 */
@Named(value="gameData")
@SessionScoped
public class GameData implements Serializable {
    
    @EJB
    private GameDAO gameDAO;
    
    public List<Gamesession> getHighScore(){
        List<Gamesession> games = gameDAO.findRange(10);
        return games;
    }
    
    public int getQuickestGame(Integer id){
        return gameDAO.findShortestTimeById(id);
    }
}