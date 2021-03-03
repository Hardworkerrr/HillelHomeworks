import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCache {
    @BeforeClass
    public static void testBegin(){
        System.out.println("------------TEST STARTED------------");
    }

    @AfterClass
    public static void testFinished(){
        System.out.println("------------TEST FINISHED------------");
    }

    @Test
    public void testPutNotNull(){
        Cache cache = new Cache();
        Assert.assertTrue(cache.put("FirstName","1","Nikolai"));
    }

    @Test
    public void testPutNull(){
        Cache cache = new Cache();
        Assert.assertFalse(cache.put("FirstName","1",null));
    }

    @Test
    public void testGetNotNull(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        Assert.assertNotNull(cache.get("FirstName","1"));
    }

    @Test
    public void testGetNull(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        Assert.assertNull(cache.get("FirstName","2"));
    }

    @Test
    public void testGetEquals(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        Assert.assertEquals("Nikolai",cache.get("FirstName","1"));
    }


    @Test
    public void testGetNotEquals(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        Assert.assertNotEquals("Oleg",cache.get("FirstName","1"));
    }
    @Test
    public void testClearAll(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        cache.put("SecondName","1","Begynov");
        cache.clear();
        Assert.assertTrue(cache.getCacheMap().isEmpty());
    }

    @Test
    public void testClearOneCacheNullPointerEx(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        cache.put("SecondName","1","Begynov");
        cache.clear("FirstName");
        Assert.assertThrows(NullPointerException.class,()->cache.getCacheMap().get("FirstName").isEmpty());
    }

    @Test
    public void testClearOneCache(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        cache.put("SecondName","1","Begynov");
        cache.clear("FirstName");
        Assert.assertNull(cache.get("FirstName","1"));
    }

    @Test
    public void testToString(){
        Cache cache = new Cache();
        cache.put("FirstName","1","Nikolai");
        cache.put("SecondName","1","Begynov");
        Assert.assertNotNull(cache.toString());
    }

}
