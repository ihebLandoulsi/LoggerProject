import Logger.Logger;
import Logger.logStrategy.Debug;
import Logger.logStrategy.Info;

public class Main {

    // Main driver method
    public static void main(String[] args)
    {
        String path = "./logs/test.txt";
        Logger logger = Logger.getInstance(path);
        logger.setLogLevel(new Info());
        logger.warn("this is a warning with %d as a variable",5);
        logger.info("this is an info with { %s } as a variable","testing...");
        logger.debug("this is a test with %.2f as a variable",3.1415);

        logger.setOutputFilePath(null);
        logger.setLogLevel(new Debug());
        logger.fatal("this is a %s log at %d ","fatal", 42);
        logger.debug("there is no error.");



    }
}
