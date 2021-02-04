package HomeWork12;

import java.util.List;


public class IntegersEx {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 25);
        double average = list.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println(average);
    }
}
