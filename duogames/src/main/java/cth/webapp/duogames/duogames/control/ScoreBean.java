/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.control;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nicla
 */
@Named(value="scorebean")
@SessionScoped
public class ScoreBean implements Serializable {
    
    
    @Setter
    @Getter
    GameBean gamebean;
    
}
