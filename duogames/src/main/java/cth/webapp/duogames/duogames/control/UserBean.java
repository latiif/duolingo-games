/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.UserDAO;
import cth.webapp.duogames.duogames.database.entity.User;
import cth.webapp.duogames.duogames.model.quiz.Question;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
import cth.webapp.duogames.duogames.services.DuoApi;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

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

    @Getter
    private DuoApi api;

    @Getter
    @Setter
    private String username = "";

    @Getter
    @Setter
    private String password = "";

    @Getter
    private Boolean isLoggedIn = false;

    User u = new User();

    /*
    
     */
    public void signin() {
        //TODO fixa
        if (username == null || password == null) {
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }
        api = new DuoApi(username, password);

        isLoggedIn = api.getIsLoggedIn();
        if (isLoggedIn) {
            userDAO.add(new User(username));
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

}
