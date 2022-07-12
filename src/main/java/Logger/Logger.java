package Logger;

import Logger.logStrategy.Debug;
import Logger.logStrategy.LogLevelStrategy;
import Logger.utils.FileHandler;
import Logger.utils.MessageFormatter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Logger implements ILogger{

    private static Logger instance;
    private String outputFilePath;
    private LogLevelStrategy logLevel;
    private  int numberOfRotations = 0;

    // Singleton Design Pattern
     //constructors
    private Logger() {this.logLevel = new Debug();}
    private Logger(String path) {
        this();
        this.outputFilePath = path;
    }
     //get instance methods
    public static Logger getInstance() {
        if (Logger.instance == null){
            Logger.instance = new Logger();
        }
        return Logger.instance;
    }
    public static Logger getInstance(String file) {
        if (Logger.instance == null)
            Logger.instance = new Logger(file);
        return Logger.instance;
    }
    // getters & setters
    public void setOutputFilePath(String file) {
        this.outputFilePath = file;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    public LogLevelStrategy getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevelStrategy logLevel) {
        this.logLevel = logLevel;
    }

    public int getLogFileMaxSize() {
        return 10240; //Bytes
    }

    private void writeLogFile(String msg) {
        FileHandler.write(this.outputFilePath,msg);
        try {
            File logFile = new File(this.outputFilePath);
            if( logFile.length() >= this.getLogFileMaxSize()) {
                this.rotateLogFiles(logFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void rotateLogFiles(File logFile) {
        this.numberOfRotations++;
        String baseName = FileHandler.getFileBaseName(logFile);
        FileHandler.compress(logFile,baseName);
        String newLogFileName = String.format(
                "%s_%d.txt",baseName,this.numberOfRotations
        );
        this.outputFilePath =
                Paths.get(logFile.getParent(),newLogFileName).toString();
        File newLogFile = new File(this.outputFilePath);
        try {
            newLogFile.createNewFile();
            logFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void debug(String msg, Object... params) {
        String formattedMessage = this.logLevel.debug(msg,params);
        if (formattedMessage == null) return;
        if (this.outputFilePath == null) {
           String log = MessageFormatter.colorizeMessage(
                    formattedMessage,
                    MessageFormatter.Color.WHITE
            );
            System.out.println(log);
        } else {
            this.writeLogFile(formattedMessage);
        }
    }

    @Override
    public void info(String msg, Object... params) {
        String formattedMessage = this.logLevel.info(msg,params);
        if (formattedMessage == null) return;
        if (this.outputFilePath == null) {
           String log = MessageFormatter.colorizeMessage(
                    formattedMessage,
                    MessageFormatter.Color.BLUE
            );
            System.out.println(log);
        } else {
            this.writeLogFile(formattedMessage);
        }
    }

    @Override
    public void warn(String msg, Object... params) {
        String formattedMessage = this.logLevel.warn(msg,params);
        if (formattedMessage == null) return;
        if (this.outputFilePath == null) {
           String log = MessageFormatter.colorizeMessage(
                    formattedMessage,
                    MessageFormatter.Color.YELLOW
            );
            System.out.println(log);
        } else {
            this.writeLogFile(formattedMessage);
        }
    }

    @Override
    public void critical(String msg, Object... params) {
        String formattedMessage = this.logLevel.critical(msg,params);
        if (formattedMessage == null) return;
        if (this.outputFilePath == null) {
           String log = MessageFormatter.colorizeMessage(
                    formattedMessage,
                    MessageFormatter.Color.ORANGE
            );
            System.out.println(log);
        } else {
            this.writeLogFile(formattedMessage);
        }
    }

    @Override
    public void fatal(String msg, Object... params) {
        String formattedMessage = this.logLevel.fatal(msg,params);
        if (formattedMessage == null) return;
        if (this.outputFilePath == null) {
           String log = MessageFormatter.colorizeMessage(
                    formattedMessage,
                    MessageFormatter.Color.RED
            );
            System.out.println(log);
        } else {
            this.writeLogFile(formattedMessage);
        }
    }
}
