/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.database.entity.User;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author nicla
 */
@Stateless
public class UserDAO extends AbstractDAO<User> {
   
    public UserDAO() {
        super(User.class);
    }
    
    /**
     * Searches the database for a user with the supplied username. Returns null if none is found.
     * @param username
     * @return 
     */
    public User findUserByUsername(String username){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query = query.select(root)
                .where(cb.equal(root.get("username"), username));
        try {
            return em.createQuery(query).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
