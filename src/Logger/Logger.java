package Logger;

import java.io.File;

public class Logger implements ILogger{
    private static Logger instance;
    private File outputFile;

    // Singleton Design Pattern
    private Logger() {}
    private Logger(File file) {
        this.outputFile = file;
    }

    public static Logger getInstance() {
        if (Logger.instance != null)
            Logger.instance = new Logger();
        return Logger.instance;
    }
    public static Logger getInstance(File file) {
        if (Logger.instance != null)
            Logger.instance = new Logger(file);
        return Logger.instance;
    }
    // getter & setter for output file
    public void setOutputFile(File file) {
        this.outputFile = file;
    }

    public File getOutputFile() {
        return this.outputFile;
    }

    @Override
    public Void debug(String msg, Object... params) {
        return null;
    }

    @Override
    public Void info(String msg, Object... params) {
        return null;
    }

    @Override
    public Void warn(String msg, Object... params) {
        return null;
    }

    @Override
    public Void critical(String msg, Object... params) {
        return null;
    }

    @Override
    public Void fatal(String msg, Object... params) {
        return null;
    }
}
