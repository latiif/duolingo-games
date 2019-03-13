package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.database.entity.GameSession;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

@Stateless
public class GameDAO extends AbstractDAO<GameSession> {
    
    @Inject
    UserBean user;
   
    public GameDAO() {
        super(GameSession.class);
    }
    
    public List<GameSession> findHighestScores(int range, String type){
        Query q = em.createQuery("SELECT g FROM GameSession g WHERE g.type = :type ORDER BY g.score DESC");
        q.setParameter("type",type);
        q.setMaxResults(range);
        return q.getResultList();
    }
    
    public int findSingleHighestScore(){
        Query q = em.createQuery("SELECT MAX(g.score) FROM GameSession g WHERE g.userid = :userid");
        q.setParameter("userid",user.getUser());
        Integer i = (int) q.getSingleResult();
        return i;
    }
    
    public BigInteger findQuickestTime(){
        Query q = em.createQuery("SELECT MIN(g.time) FROM GameSession g WHERE g.userid = :userid");
        q.setParameter("userid",user.getUser());
        return Optional.ofNullable((BigInteger) q.getSingleResult()).orElse(BigInteger.valueOf(0));
    }
    
    public BigInteger findSlowestTime(){
        Query q = em.createQuery("SELECT MAX(g.time) FROM GameSession g WHERE g.userid = :userid");
        q.setParameter("userid",user.getUser());
        return Optional.ofNullable((BigInteger) q.getSingleResult()).orElse(BigInteger.valueOf(0));
    }
    

    public int findTotalGames() {
        Query q = em.createQuery("SELECT COUNT(g) FROM GameSession g WHERE g.userid = :userid");
        q.setParameter("userid",user.getUser());
        long l = (long) q.getSingleResult();
        return (int) l;
    }
}
