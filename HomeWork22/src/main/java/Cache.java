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

    public Cache() {

    }

    /**
     * Put new Data into Storage
     *
     * @param cache - Cache name
     * @param key   - Key of Cache Map
     * @param o     - Object of Cache Map
     * @return true if successful false if not
     * @author OlegAtaulin
     * @since 1.0.0
     */
    @Override
    public boolean put(String cache, String key, Object o) {
        CustomLogger.getDebugLogger().debug("Putting new element started ...");
        autoClear();
        if (o == null) {
            CustomLogger.getErrorLogger().error("User tried to put null object");
            CustomLogger.getDebugLogger().debug("Object not added ");
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
        CustomLogger.getDebugLogger().debug("Object added");
        return true;
    }

    /**
     * Getting Data from Cache Storage
     *
     * @param cache - Cache name
     * @param key   - Key of Cache Map
     * @return Object of Cache Map
     * @author OlegAtaulin
     * @since 1.0.0
     */
    @Override
    public Object get(String cache, String key) {
        autoClear();
        try {
            for (Map.Entry entry : cacheMap.get(cache).entrySet()) {
                if (entry.getKey().equals(key)) {
                    CustomLogger.getConsoleLogger().info("Object{" + entry.getKey() + "=" + entry.getValue() + "}");
                }
            }
            CustomLogger.getDebugLogger().debug("The user received the object");
            return cacheMap.get(cache).get(key);
        } catch (NullPointerException ex) {
            CustomLogger.getConsoleLogger().info("No cache or key exists");
            CustomLogger.getWarnLogger().warn("No cache or key exists");
            CustomLogger.getDebugLogger().debug("The user did not receive the object");
            return null;
        }
    }

    /**
     * Clearing all Caches
     *
     * @author OlegAtaulin
     * @since 1.0.0
     */
    @Override
    public void clear() {
        CustomLogger.getDebugLogger().debug("All caches cleared");
        cacheMap = new HashMap<>();
    }

    /**
     * Clearing only one Cache from params
     *
     * @author OlegAtaulin
     * @since 1.0.0
     */
    @Override
    public void clear(String cache) {
        CustomLogger.getDebugLogger().debug("Cache " + cache + " cleared");
        cacheMap.keySet().removeIf(key -> key.equals(cache));
    }

    /**
     * Auto clearing Data in Cache, if work time in program more or equals 10 secs
     *
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public void autoClear() {
        if (System.currentTimeMillis() - startTime >= 10000) {
            CustomLogger.getInfoLogger().info("The cache time is up, clearing all data...");
            clear();
        }
    }

    /**
     * CacheMap Getter
     *
     * @return {@link HashMap}
     * @author OlegAtaulin
     * @since 1.0.0
     */
    public Map<String, Map<String, Object>> getCacheMap() {
        return cacheMap;
    }

    /**
     * Printing Data
     *
     * @author OlegAtaulin
     * @since 1.0.0
     */
    @Override
    public String toString() {
        CustomLogger.getDebugLogger().debug("The user printing cache ...");
        autoClear();
        return "Cache" +
                cacheMap;
    }

}
