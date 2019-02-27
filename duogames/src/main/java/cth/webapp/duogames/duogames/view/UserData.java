/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.view;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author stina
 */
@Named(value="userData")
@SessionScoped
public class UserData implements Serializable {
    @Getter
    @Setter
    private String username = "";

    @Getter
    @Setter
    private String password = "";
    
}
