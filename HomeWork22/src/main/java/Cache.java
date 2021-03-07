import java.util.HashMap;
import java.util.Map;

/**
 * @author OlegAtaulin
 * @version 1.0.0
 * Custom Cache for Data Storage
 */
public class Cache implements CacheInterface {

    private Map<String, Map<String, Object>> cacheMap = new HashMap<>();
    private static final long startTime = System.currentTimeMillis();
    private static final String put = "Putting new element started ...";
    private static final String putError = "User tried to put null object";
    private static final String putSuccess = "Object added";
    private static final String putNotSuccess = "Object not added";
    private static final String printObject = "Object{%s=%s}";
    private static final String getSuccess = "The user received the object";
    private static final String getWarn = "No cache or key exists";
    private static final String getNotSuccess= "The user did not receive the object";
    private static final String clearAll= "All caches cleared";
    private static final String clearCache= "Cache %s cleared";
    private static final String autoClear= "The cache time is up, clearing all data...";
    private static final String printCache= "The user printing cache ...";


    public Cache() {

    }

    /**
     * Put new Data into Storage
     *
     * @param cache - Cache name
     * @param key   - Key of Cache Map
     * @param o     - Object of Cache Map
     * @return true if successful false if not
     * @since 1.0.0
     */
    @Override
    public boolean put(String cache, String key, Object o) {
        CustomLogger.getDebugLogger().debug(put);
        autoClear();
        if (o == null) {
            CustomLogger.getErrorLogger().error(putError);
            CustomLogger.getDebugLogger().debug(putNotSuccess);
            return false;
        }
        if (cacheMap.get(cache) == null) {
            CustomLogger.getInfoLogger().info("New cache created");
            Map<String, Object> newElement = new HashMap<>();
            newElement.put(key, o);
            cacheMap.put(cache, newElement);
        } else {
            cacheMap.get(cache).put(key, o);
        }
        CustomLogger.getDebugLogger().debug(putSuccess);
        return true;
    }

    /**
     * Getting Data from Cache Storage
     *
     * @param cache - Cache name
     * @param key   - Key of Cache Map
     * @return Object of Cache Map
     * @since 1.0.0
     */
    @Override
    public Object get(String cache, String key) {
        autoClear();
        try {
            for (Map.Entry entry : cacheMap.get(cache).entrySet()) {
                if (entry.getKey().equals(key)) {
                    CustomLogger.getConsoleLogger().info(String.format(printObject,entry.getKey(),entry.getValue()));
                }
            }
            CustomLogger.getDebugLogger().debug(getSuccess);
            return cacheMap.get(cache).get(key);
        } catch (NullPointerException ex) {
            CustomLogger.getConsoleLogger().info(getWarn);
            CustomLogger.getWarnLogger().warn(getWarn);
            CustomLogger.getDebugLogger().debug(getNotSuccess);
            return null;
        }
    }

    /**
     * Clearing all Caches
     *
     * @since 1.0.0
     */
    @Override
    public void clear() {
        CustomLogger.getDebugLogger().debug(clearAll);
        cacheMap = new HashMap<>();
    }

    /**
     * Clearing only one Cache from params
     *
     * @since 1.0.0
     */
    @Override
    public void clear(String cache) {
        CustomLogger.getDebugLogger().debug(String.format(clearCache,cache));
        cacheMap.keySet().removeIf(key -> key.equals(cache));
    }

    /**
     * Auto clearing Data in Cache, if work time in program more or equals 10 secs
     *
     * @since 1.0.0
     */
    public void autoClear() {
        if (System.currentTimeMillis() - startTime >= 10000) {
            CustomLogger.getInfoLogger().info(autoClear);
            clear();
        }
    }

    /**
     * CacheMap Getter
     *
     * @return {@link HashMap}
     * @since 1.0.0
     */
    public Map<String, Map<String, Object>> getCacheMap() {
        return cacheMap;
    }

    /**
     * Printing Data
     *
     * @since 1.0.0
     */
    @Override
    public String toString() {
        CustomLogger.getDebugLogger().debug(printCache);
        autoClear();
        return "Cache" +
                cacheMap;
    }

}
