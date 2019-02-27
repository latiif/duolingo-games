package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.database.entity.GameSession;
import javax.ejb.Stateless;

@Stateless
public class GameDAO extends AbstractDAO<GameSession> {
   
    public GameDAO() {
        super(GameSession.class);
    }
    
}
