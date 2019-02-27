/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.dao;

import cth.webapp.duogames.duogames.database.entity.User;
import javax.ejb.Stateless;

/**
 *
 * @author nicla
 */
@Stateless
public class UserDAO extends AbstractDAO<User> {
   
    public UserDAO() {
        super(User.class);
    }
    
    
}
