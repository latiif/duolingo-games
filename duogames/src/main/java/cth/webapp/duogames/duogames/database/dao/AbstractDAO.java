/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.database.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;


/**
 *
 * @author nicla
 */
public abstract class AbstractDAO<T> {
     @PersistenceContext
    private EntityManager em;
     private Class cl;
     
     public AbstractDAO(Class c){
         this.cl = c;
     }
     
    protected EntityManager getEntityManager(){
        return em;
    }

    public List<T> findAll(){
        em.createNamedQuery("Users.findAll");
        return null;
    }
    public List<T> findRange(){
        CriteriaQuery q = em.getCriteriaBuilder().createQuery();
        q.select(q.from(cl));
        Query qq = em.createQuery(q);
        qq.setFirstResult(0);
        qq.setMaxResults(5);
        return qq.getResultList();
    }
    
    public User findUser(String username){
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
    /**
     * Finds and returns database entry by its primary key.
     * @param entity
     * @return 
     */
    public Object findById(int id){
       return em.find(cl, id);
    }
    
    /**
     * Adds the new entity to the database.
     * @param entity 
     */
    public void add(T entity){
        em.persist(entity);
    }
    
}
