package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.database.entity.Gamesession;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

@Stateless
public class GameDAO extends AbstractDAO<Gamesession> {
    
    @Inject
    UserBean user;
   
    public GameDAO() {
        super(Gamesession.class);
    }
    
    public List<Gamesession> findHighestScores(int range){
        Query q = em.createQuery("SELECT g FROM Gamesession g ORDER BY g.score DESC");
        q.setMaxResults(range);
        return q.getResultList();
    }
    public BigInteger findQuickestTime(){
        Query q = em.createQuery("SELECT MIN(g.time) FROM Gamesession g WHERE g.userid = :userid");
        q.setParameter("userid",user.getUser());
        return (BigInteger) q.getSingleResult();
    }

    public int findTotalGames() {
        Query q = em.createQuery("SELECT COUNT(g) FROM Gamesession g WHERE g.userid = :userid");
        q.setParameter("userid",user.getUser());
        long l = (long) q.getSingleResult();
        return (int) l;
    }
}
