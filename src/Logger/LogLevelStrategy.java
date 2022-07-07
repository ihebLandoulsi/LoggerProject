package Logger;

//TODO: implement subclasses and methods
public abstract class LogLevelStrategy {
    public String debug(String msg, Object... params){return null;}
    public String info(String msg, Object... params){return null;}
    public String warn(String msg, Object... params){return null;}
    public String critical(String msg, Object... params){return null;}
    public String fatal(String msg, Object... params){return null;}
}
