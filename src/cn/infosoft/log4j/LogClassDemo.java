package cn.infosoft.log4j;

import org.apache.log4j.*;

public class LogClassDemo {
    private static org.apache.log4j.Logger log = Logger.getLogger(LogClassDemo.class);
    public static void main(String[] args) {
        log.setLevel(Level.WARN);

        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");
    }
}
