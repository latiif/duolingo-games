package cth.webapp.duogames.duogames.utils;

public class TimeFormatter {

    /***
     * Returns time formatted as HH:MM:SS.
     * @param time
     * @return 
     */
    public static String format(long time) {
        return String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, time % 60);
    }
}
