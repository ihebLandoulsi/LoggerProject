package Logger;

public interface ILogger {
    void debug(String msg, Object... params);
    void info(String msg, Object... params);
    void warn(String msg, Object... params);
    void critical(String msg, Object... params);
    void fatal(String msg, Object... params);
}
