import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogger {
    private static final Logger debugLogger = LoggerFactory.getLogger("logger.debug");
    private static final Logger infoLogger = LoggerFactory.getLogger("logger.info");
    private static final Logger errorLogger = LoggerFactory.getLogger("logger.error");
    private static final Logger warnLogger = LoggerFactory.getLogger("logger.warn");
    private static final Logger resultLogger = LoggerFactory.getLogger("logger.result");


    public static Logger getInfoLogger() {
        return infoLogger;
    }

    public static Logger getDebugLogger() {
        return debugLogger;
    }

    public static Logger getErrorLogger() {
        return errorLogger;
    }

    public static Logger getWarnLogger() {
        return warnLogger;
    }

    public static Logger getResultLogger() {
        return resultLogger;
    }
}
