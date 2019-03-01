/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.UserDAO;
import cth.webapp.duogames.duogames.database.entity.User;
import cth.webapp.duogames.duogames.services.DuoApi;
import cth.webapp.duogames.duogames.view.UserData;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author latiif
 */
@Named(value="user")
//@RequestScoped
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserDAO userDAO;
    
    @Inject
    private UserData userData;

    @Getter
    private DuoApi api;
    @Getter
    private Boolean isLoggedIn = false;
    
    @Getter
    private User user;

    public void signin() {
        if (userData.getUsername() == null || userData.getPassword() == null) {
            return;
        }

        if (userData.getUsername().isEmpty() || userData.getPassword().isEmpty()) {
            return;
        }
        api = new DuoApi(userData.getUsername(), userData.getPassword());

        isLoggedIn = api.getIsLoggedIn();
        if (isLoggedIn) {
            createUser();
        }
            redirect();
    }
   
    public void redirect() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/duogames/userprofile.xhtml");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void createUser() {
        user = new User(userData.getUsername());
        User tmp = userDAO.findUserByUsername(user.getUsername());
        if(tmp == null){
            userDAO.add(user);
        } else {
            user.setId(tmp.getId());
            System.out.println(user.getId());
                    
        }
    }
}
