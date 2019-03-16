package cth.webapp.duogames.duogames.view;

import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.database.entity.GameSession;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "gameData")
@SessionScoped
public class GameData implements Serializable {

    @EJB
    private GameDAO gameDAO;

    public List<GameSession> getHighScore(String type) {
        return gameDAO.findHighestScores(10, type);
    }

    public String getQuickestGame() {
        return TimeFormatter.format(gameDAO.findQuickestTime().longValue());
    }

    public int getTotalGames() {
        return gameDAO.findTotalGames();
    }
}
