/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nicla
 */
public class UserDAO<T> {
    @PersistenceContext
    private EntityManager em;

    public List<T> findAll(){
        em.createNamedQuery("Users.findAll");
        
        return null;
    }
}
