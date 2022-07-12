package Logger.logStrategy;

import Logger.utils.MessageFormatter;

public abstract class LogLevelStrategy {

    public String debug(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(
                "DEBUG",
                msg,
                params
        );
        return formattedMessage;
    }

    public String info(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(
                "INFO",
                msg,
                params
        );
        return formattedMessage;
    }

    public String warn(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(
                "WARNING",
                msg,
                params
        );
        return formattedMessage;
    }

    public String critical(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(
                "CRITICAL",
                msg,
                params
        );
        return formattedMessage;
    }

    public String fatal(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(
                "FATAL",
                msg,
                params
        );
        return formattedMessage;
    }
}
