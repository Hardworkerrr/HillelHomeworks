import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author OlegAtaulin
 * @version 1.0.0
 * Custom Logger for logging information
 */

public class CustomLogger {
    private static final Logger debugLogger = LoggerFactory.getLogger("logger.debug");
    private static final Logger infoLogger = LoggerFactory.getLogger("logger.info");
    private static final Logger errorLogger = LoggerFactory.getLogger("logger.error");
    private static final Logger warnLogger = LoggerFactory.getLogger("logger.warn");
    private static final Logger consoleLogger = LoggerFactory.getLogger("logger.stdout");

    /**
     * CustomLogger Getter
     *
     * @return {@link Logger}
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public static Logger getConsoleLogger() {
        return consoleLogger;
    }

    /**
     * CustomLogger Getter
     *
     * @return {@link Logger}
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public static Logger getInfoLogger() {
        return infoLogger;
    }

    /**
     * CustomLogger Getter
     *
     * @return {@link Logger}
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public static Logger getDebugLogger() {
        return debugLogger;
    }

    /**
     * CustomLogger Getter
     *
     * @return {@link Logger}
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public static Logger getErrorLogger() {
        return errorLogger;
    }

    /**
     * CustomLogger Getter
     *
     * @return {@link Logger}
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public static Logger getWarnLogger() {
        return warnLogger;
    }

}
