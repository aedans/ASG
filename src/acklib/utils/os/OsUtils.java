package acklib.utils.os;

/**
 * @author hacke
 *         <p>
 *         Collection 0f operating system utilities
 */
public final class OsUtils {
    /*
     * String representation of the operating system
     */
    private static String OS = System.getProperty("os.name").trim().toLowerCase();

    /*
     * Utility class, cannot be instantiated
     */
    private OsUtils() {
    }

    /**
     * Returns whether or not the operating system is windows
     *
     * @return if the operating system is windows
     */
    public static boolean isWindows() {
        return OS.contains("windows");
    }

    /**
     * Returns whether or not the operating system is unix
     *
     * @return if the operating system is unix
     */
    public static boolean isUnix() {
        return OS.contains("nix") || OS.contains("aix") || OS.contains("nux");
    }

    /**
     * Returns whether or not the operating system is osx
     *
     * @return if the operating system is osx
     */
    public static boolean isMac() {
        return OS.contains("mac");
    }

    /**
     * Returns whether or not the operating system is solaris
     *
     * @return if the operating system is solaris
     */
    public static boolean isSolaris() {
        return OS.contains("sunos");
    }

    /**
     * Returns the string representation of the operating system
     *
     * @return the operating system string
     */
    public static String getOS() {
        return OS;
    }
}
