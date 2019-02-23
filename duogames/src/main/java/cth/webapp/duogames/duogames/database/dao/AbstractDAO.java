/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


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

    public List<T> findAll(){
        em.createNamedQuery("Users.findAll");
        
        return null;
    }
    public List<T> findRange(){
        //CriteriaQuery q = em.getCriteriaBuilder().createQuery();
        //q.select(q.from(cl));
        //Query qq = em.getCriteriaBuilder().createQuery(q);
        return null;
    }

    
}
