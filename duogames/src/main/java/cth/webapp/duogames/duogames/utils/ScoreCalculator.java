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
public class ScoreCalculator {

    /**
     *
     * @param correct
     * @param time
     * @return
     */
    public static int calculateScore(int correct, long time) {
        int score = correct * 100;
        score += Math.max((90000 - time) / 100, 0);
        return score;
    }

}
