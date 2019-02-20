/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author latiif
 */
@Entity
public class User {

    @Getter
    private String name;
    
    @Id
    @Getter
    private String id;

    @Getter
    private List<String> langs;

    @Getter
    @Setter
    private String currLang;

    public User(String name, String id) {

        this.name = name;
        this.id = id;

    }

}
