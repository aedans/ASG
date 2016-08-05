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
    private static ArrayList<PrintStream> fd = new ArrayList<>(1);

    public static void addOutputStream(final PrintStream stream){
        fd.add(stream);
    }

    public static void removeOutputStream(final PrintStream stream){
        fd.remove(stream);
    }

    public static void println(final String s){
        fd.forEach(strm->strm.println(s));
    }

    public static void print(final String s){
        fd.forEach(strm->strm.print(s));
    }

    public static void printf(final String fmt, final Object...args){
        fd.forEach(strm->strm.printf(fmt, args));
    }
}
