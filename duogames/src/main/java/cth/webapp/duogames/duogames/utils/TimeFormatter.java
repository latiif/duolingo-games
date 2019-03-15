/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.utils;

/**
 *
 * @author stina
 */
public class TimeFormatter {

    public static String format(long time) {
        return String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, time % 60);
    }
}
