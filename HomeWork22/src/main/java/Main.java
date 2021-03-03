/**
 * @author OlegAtaulin
 * @version 1.0.0
 * Main program
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        cache.put("FirstName", "1", "Oleg");
        cache.put("FirstName", "2", "Nikolai");
        cache.put("FirstName", "3", "Dima");
        cache.put("FirstName", "4", "Vasya");
        cache.put("FirstName", "5", "Igor");
        cache.put("SecondName", "1", "Baskov");
        cache.put("SecondName", "2", "Tyrikov");
        cache.put("SecondName", "3", "Bistrikov");
        cache.put("SecondName", "4", "Koreshkov");
        cache.put("SecondName", "5", "Polyakov");
        cache.put("SecondName", "5", "Igorev");
        cache.put("SecondName", "5", null);
        CustomLogger.getConsoleLogger().info(cache.toString());
        Object obj = cache.get("FirstName", "4");
        CustomLogger.getConsoleLogger().info("Value of key : " + obj.toString());
        cache.clear("SecondName");
        CustomLogger.getConsoleLogger().info(cache.toString());
        Object obj2 = cache.get("SecondName", "Igorev");
        Thread.sleep(10000);
        CustomLogger.getConsoleLogger().info(cache.toString());
    }
}
