package main.java.se.kth.iv1350.eliasandreas.util;


/*
 * Specifies an object that can print to a log. This interface
 * does not handle log locations, it is up to the implementing
 * class to decide where the log is.
 */
public interface Logger {
    /*
     * Logs the message.
     * 
     * @param message will be printed to log.
     */
    void log(String message);

}
