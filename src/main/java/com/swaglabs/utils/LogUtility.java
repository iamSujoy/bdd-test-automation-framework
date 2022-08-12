package com.swaglabs.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtility {
    private static final Logger LOGGER = LogManager.getLogger(LogUtility.class);

    private LogUtility() {}

    public static void logTrace(String message){
        LOGGER.trace(message);
    }

    public static void logDebug(String message){
        LOGGER.debug(message);
    }

    public static void logInfo(String message){
        LOGGER.info(message);
    }

    public static void logWarn(String message){
        LOGGER.warn(message);
    }

    public static void logError(String message){
        LOGGER.error(message);
    }

    public static void logFatal(String message){
        LOGGER.fatal(message);
    }
}
