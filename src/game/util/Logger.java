package game.util;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by kaden on 8/4/16.
 *
 * Logger to log output to the console/log file
 */
public class Logger {
    /* list of streams to print to */
    private static ArrayList<PrintStream> fd = new ArrayList<>(1);

    /**
     * add an output stream
     * @param stream stream to be added
     */
    public static void addOutputStream(final PrintStream stream){
        fd.add(stream);
    }

    /**
     * remove an output stream
     * @param stream stream to be removed
     */
    public static void removeOutputStream(final PrintStream stream){
        fd.remove(stream);
    }

    /**
     * print a string to all streams with a newline
     * @param s string to print
     */
    public static void println(final String s){
        fd.forEach(strm->strm.println(s));
    }

    /**
     * print a string to all streams
     * @param s string to print
     */
    public static void print(final String s){
        fd.forEach(strm->strm.print(s));
    }

    /**
     * print a formatted string to all streams
     * @param fmt format to use
     * @param args arguments for format
     */
    public static void printf(final String fmt, final Object...args){
        fd.forEach(strm->strm.printf(fmt, args));
    }
}
