package net.fettlol.utilmod.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {

    public static Logger logger = LogManager.getLogger();

    public static void log(String message) {
        logger.info("[Fettlol UtilMod] " + message);
    }

}
