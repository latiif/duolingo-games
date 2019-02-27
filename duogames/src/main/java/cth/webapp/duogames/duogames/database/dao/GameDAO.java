package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.database.entity.Gamesession;
import javax.ejb.Stateless;

@Stateless
public class GameDAO extends AbstractDAO<Gamesession> {
   
    public GameDAO() {
        super(Gamesession.class);
    }
    
}
