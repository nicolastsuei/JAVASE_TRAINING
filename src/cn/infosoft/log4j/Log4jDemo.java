package cn.infosoft.log4j;

import org.apache.log4j.Logger;

public class Log4jDemo {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger (Log4jDemo.class.getName());
    public static void main(String[] args) {
        log.debug("Hello this is an debug message");
        log.info("Hello this is an info message");

    }
}
