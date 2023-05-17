package main.java.se.kth.iv1350.eliasandreas.util;

/*
 * prints to <code>system.out</code>.
 */
public class ConsoleLogger implements Logger {
    /*
     * Prints the specified string to <code>system.out</code>.
     *
     * @param message will be printed to <code>system.out</code>.
     */
    @Override
    public void log(String message) {
        System.out.println(message);

    }
}
