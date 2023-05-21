package main.java.se.kth.iv1350.eliasandreas.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logs to a file
 */
public class FileLogger implements Logger {
    private PrintWriter logStream;

    /**
     * Creates an instance of the FileLogger
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("Can Not Log.");
            ioe.printStackTrace();
        }
    }

    /*
     * Prints the specified string to the file.
     *
     * @param The message that will be printed.
     */
    public void log(String message) {
        logStream.println(message);
    }
}
