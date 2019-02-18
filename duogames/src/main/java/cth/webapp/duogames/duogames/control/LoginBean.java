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
import javax.annotation.PostConstruct;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author latiif
 */
@Named("auth")
//@RequestScoped
@SessionScoped
public class LoginBean implements Serializable {

    
    public String getHi(){
        return "HIIII";
    }
    


    @Getter
    @Setter
    private String username = "";

    @Getter
    @Setter
    private String password = "";

    @Getter
    private Boolean isLoggedIn = false;

    /*
    
     */
    public void signin() {

         DuoApi user;

        if (username == null || password == null) {
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

        user = new DuoApi(username, password);

     

        isLoggedIn = user.getIsLoggedIn();
    }
}
