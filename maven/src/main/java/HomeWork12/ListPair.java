package HomeWork12;

import java.util.List;
import java.util.stream.Collectors;

public class ListPair {
    public static void main(String[] args) {
        List<String> str = List.of("one","TWO","THREE","four","five","SIX").stream().map(String::toUpperCase).collect(Collectors.toList());
        List<StringPair> str1 = str.stream().map(s -> new StringPair(s.toLowerCase(),s)).collect(Collectors.toList());
        System.out.println(str1.toString());
    }
}
