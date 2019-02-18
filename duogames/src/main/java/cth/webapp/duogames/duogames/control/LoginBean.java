/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import com.latiif.duoapi.DuoApi;
import cth.webapp.duogames.duogames.model.User;
import java.io.Serializable;
import static java.lang.System.out;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author latiif
 */
@Named("login")
//@RequestScoped
@SessionScoped
public class LoginBean implements Serializable {

    
    public String getHi(){
        return "HIIII";
    }
    //@ManagedProperty(value = "#{user}")
    private UserBean userbean;

    private DuoApi user;

    @Getter
    @Setter
    private String username = "";

    @Getter
    @Setter
    private String password = " ";

    @Getter
    private Boolean isLoggedIn = false;

    /*
    
     */
    public void signin() {

        if (username == null || password == null) {
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

        user = new DuoApi(username, password);

        userbean = new UserBean();
        userbean.setUser(new User(user.getUserInfo().get("fullname"), user.getUserInfo().get("username")));

        isLoggedIn = user.getIsLoggedIn();
    }

    @PostConstruct // CDI life cycle callbacks
    void post() {
        username = " ";
        password = " ";
    }
}
