package Logger.utils;

public class MessageFormatter {
    public enum Color {
        RED("\033[0;31m"),
        GREEN("\033[0;32m"),
        BLUE("\033[0;34m"),
        YELLOW("\033[0;33m"),
        WHITE("\033[0;37m"),
        BLACK("\033[0;30m");

        public final String label;

        private Color(String label) {
            this.label = label;
        }
    }
    private final static  String ANSI_RESET = "\\u001B[0m";

    //TODO: Implement and document method
    public static String format(String msg, Object... params) throws Exception{
        throw new Exception("methode not implemented");
    }

    //TODO: Implement and document method
    public static String ColorizeMessage(String message, Color color) throws Exception{
        throw new Exception("method not impemented");
    }


}
