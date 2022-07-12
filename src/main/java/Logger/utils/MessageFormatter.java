package Logger.utils;

import java.util.Date;

public class MessageFormatter {
    public enum Color {
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        BLUE("\u001B[34m"),
        YELLOW("\u001B[33m"),
        ORANGE("\u001b[38;5;208m"),
        WHITE("\u001B[37m"),
        BLACK("\u001B[30m");

        public final String label;

        Color(String label) {
            this.label = label;
        }
    }
    private final static  String ANSI_RESET = "\u001B[0m";

    /**
     * format the log message with useful information.
     * @param label the label attached to the message.
     * @param msg the text that will be displayed.
     * @param params the args passed to print function.
     * @return the formatted message containing the label and date of the message
     */
    public static String format(String label, String msg, Object... params){
        return String.format(
                label + " [" + new Date() + "] : " + msg + "\n",
                params
        );
    }

    /**
     * add color to message text on console using ANSI Colors
     * @param message the message that will be colored
     * @param color the color chosen for the text
     * @return  the colored message for the console.
     */
    public static String colorizeMessage(String message, Color color){
        return color.label + message + MessageFormatter.ANSI_RESET;
    }


}
