package Logger;

import Logger.utils.MessageFormatter;

//TODO: implement subclasses and methods
public abstract class LogLevelStrategy {

    public String debug(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(msg, params);
        formattedMessage = MessageFormatter.ColorizeMessage(
                formattedMessage,
                MessageFormatter.Color.WHITE
        );
        return formattedMessage;
    }

    public String info(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(msg, params);
        formattedMessage = MessageFormatter.ColorizeMessage(
                formattedMessage,
                MessageFormatter.Color.YELLOW
        );
        return formattedMessage;
    }

    public String warn(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(msg, params);
        formattedMessage = MessageFormatter.ColorizeMessage(
                formattedMessage,
                MessageFormatter.Color.YELLOW
        );
        return formattedMessage;
    }

    public String critical(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(msg, params);
        formattedMessage = MessageFormatter.ColorizeMessage(
                formattedMessage,
                MessageFormatter.Color.RED
        );
        return formattedMessage;
    }

    public String fatal(String msg, Object... params) {
        String formattedMessage = MessageFormatter.format(msg, params);
        formattedMessage = MessageFormatter.ColorizeMessage(
                formattedMessage,
                MessageFormatter.Color.RED);

        return formattedMessage;
    }
}
