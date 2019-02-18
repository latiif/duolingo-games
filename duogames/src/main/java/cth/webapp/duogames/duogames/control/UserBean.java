/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.User;
import cth.webapp.duogames.duogames.services.DuoApi;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author latiif
 */
@Named("user")
//@RequestScoped
@SessionScoped
public class UserBean implements Serializable {
    
    
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

    /*
    
     */
    public void signin() {

       

        if (username == null || password == null) {
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return;
        }

       api = new DuoApi(username, password);

        isLoggedIn = api.getIsLoggedIn();
        
       
    }


}
