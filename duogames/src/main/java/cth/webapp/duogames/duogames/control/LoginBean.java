/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import com.latiif.duoapi.DuoApi;
import java.io.Serializable;
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
public class LoginBean implements Serializable{
    
    private DuoApi user;
    
    @Getter
    @Setter
    private String username;
    
    @Getter
    @Setter
    private String password;
    

    @Getter
    private boolean isLoggedIn = false;
    
    public LoginBean(){
        username = "";
        password = "";
    }
    
    
    /*
    
    */
    public void login(){
        if (username.isEmpty() || password.isEmpty())
            return;
        
        user = new DuoApi(username, password);
        
        isLoggedIn = user.getIsLoggedIn();
    }
    
}
