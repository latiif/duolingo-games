/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author latiif
 */
public class User {

    @Getter
    private String name;

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
