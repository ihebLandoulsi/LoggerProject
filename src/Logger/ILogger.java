package Logger;

public interface ILogger {
    Void debug(String msg, Object... params);
    Void info(String msg, Object... params);
    Void warn(String msg, Object... params);
    Void critical(String msg, Object... params);
    Void fatal(String msg, Object... params);
}
