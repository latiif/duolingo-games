/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author nicla
 */
public abstract class Game {

    int id;
    boolean isFinished;
    Map<String, List<String>> dict;
}
