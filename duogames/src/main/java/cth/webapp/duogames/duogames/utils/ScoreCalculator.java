package cth.webapp.duogames.duogames.utils;

public class ScoreCalculator {

    /**
     * Simple score calculation based on time and correct answers.
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
