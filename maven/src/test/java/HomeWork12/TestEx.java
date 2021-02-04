package HomeWork12;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.NoSuchElementException;


public class TestEx {
    @Test
    public void integersTestPos() {
        List<Integer> list = List.of(10, 20);
        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        Assert.assertEquals(15.0, average, 0.0);
    }

    @Test
    public void integersTestListOfNulls() {
        List<Integer> list = List.of();
        Assert.assertThrows(NoSuchElementException.class, () -> list.stream().mapToInt(Integer::intValue).average().getAsDouble());
    }

    @Test
    public void integersTestNeg() {
        List<Integer> list = List.of(-10, -20);
        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        Assert.assertEquals(-15.0, average, 0.0);
    }

    @Test
    public void integersTestZero() {
        List<Integer> list = List.of(0,0,0,0,0);
        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        Assert.assertEquals(0.0, average, 0.0);
    }

}
