/**
 * @author OlegAtaulin
 * @version 1.0.0
 * Interface for Cache
 */
public interface CacheInterface {
    boolean put(String cache, String key, Object o);

    Object get(String cache, String key);

    void clear();

    void clear(String cache);
}
