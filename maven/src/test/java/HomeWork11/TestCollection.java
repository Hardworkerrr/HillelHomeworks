package HomeWork11;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestCollection {


    @BeforeClass
    public static void testBegin(){
        System.out.println("------------TEST STARTED------------");
    }

    @AfterClass
    public static void testFinished(){
        System.out.println("------------TEST FINISHED------------");
    }

    @Test
    public void testAddStr(){
        Collection<String> str = new Collection<>();
        Assert.assertTrue(str.add("a"));
        System.out.println();
    }

    @Test
    public void testAddInt(){
        Collection<Integer> str = new Collection<>();
        Assert.assertThrows(ArrayStoreException.class,()-> str.add(1));
    }

    @Test
    public void testAddByInd(){
        Collection<String> str = new Collection<>();
        Assert.assertTrue(str.add(0,"asd"));
    }

    @Test
    public void testAddByIndInt(){
        Collection<Integer> str = new Collection<>();
        Assert.assertThrows(ArrayStoreException.class,()-> str.add(0,1));
    }

    @Test
    public void testAddByNegativeInd(){
        Collection<String> str = new Collection<>();
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()-> str.add(-1,"element"));
    }

    @Test
    public void testRemoveInd(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertTrue(str.remove(1));
    }

    @Test
    public void testRemoveNegativeInd(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()-> str.remove(-1));
    }

    @Test
    public void testRemoveNullInd(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()-> str.remove(22));
    }

    @Test
    public void testRemoveObj(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertTrue(str.remove("a"));
    }

    @Test
    public void testRemoveNotExistObj(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertFalse(str.remove("h"));
    }

    @Test
    public void testGet(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertNotNull(str.get(0));
    }

    @Test
    public void testGetNegativeInd(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()->str.get(-1));
    }

    @Test
    public void testGetNotExistInd(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()->str.get(21));
    }

    @Test
    public void testContainObj(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertTrue(str.contain("a"));
    }

    @Test
    public void testContainNotExistObj(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertFalse(str.contain("h"));
    }

    @Test
    public void testEqualsCollections(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Collection<String> str1 = new Collection<>();
        str1.add("a");
        str1.add("b");
        str1.add("c");
        Assert.assertEquals(str.equals(str1),str1.equals(str));
    }

    @Test
    public void testEqualsItself(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertTrue(str.equals(str));
    }

    @Test
    public void testEqualsDifferentSize(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Collection<String> str1 = new Collection<>();
        str1.add("a");
        str1.add("b");
        str1.add("c");
        str1.add("c");
        Assert.assertFalse(str.equals(str1));
    }
    @Test
    public void testEqualsDifferentElements(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Collection<String> str1 = new Collection<>();
        str1.add("h");
        str1.add("j");
        str1.add("k");
        Assert.assertFalse(str.equals(str1));
    }

    @Test
    public void testClear(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertTrue(str.clear());
    }

    @Test
    public void testGetSizeOfThreeElements(){
        Collection<String> str = new Collection<>();
        str.add("a");
        str.add("b");
        str.add("c");
        Assert.assertEquals(3, str.size());
    }

    @Test
    public void testGetSizeOfZeroElements(){
        Collection<String> str = new Collection<>();
        Assert.assertEquals(0, str.size());
    }

    @Test
    public void testGetSizeNotNegative(){
        Collection<String> str = new Collection<>();
        Assert.assertTrue(str.size()>=0);
    }
    @Test
    public void testToString(){
        Collection<String> str = new Collection<>();
        Assert.assertNotNull(str.toString());
    }












}
