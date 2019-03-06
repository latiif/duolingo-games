package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.control.UserBean;
import cth.webapp.duogames.duogames.database.entity.Gamesession;
import cth.webapp.duogames.duogames.database.entity.Gamesession_;
import cth.webapp.duogames.duogames.database.entity.User;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class GameDAO extends AbstractDAO<Gamesession> {
   
    public GameDAO() {
        super(Gamesession.class);
    }
    
        /**
     * Searches the database for a user with the supplied username. Returns null if none is found.
     * @param userid
     * @return 
     */
    public int findShortestTimeById(Integer userid){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Gamesession> query = cb.createQuery(Gamesession.class);
        Root<Gamesession> root = query.from(Gamesession.class);
        query = query.select(root)
                .where(cb.equal(root.get("userid"), userid))
                
                ;
        try {
            return em.createQuery(query).getFirstResult();
        } catch (NoResultException nre) {
            return 55;
        }
    }
}
