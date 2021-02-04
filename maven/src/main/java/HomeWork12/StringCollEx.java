package HomeWork12;

import java.util.List;

public class StringCollEx {
    public static void main(String[] args) {
        List<String> str = List.of("asd", "asdasd", "bdbdbdb", "LION", "BONBON", "soon", "Bool", "good");
        str.stream().filter(e -> e.length() == 4).filter(e-> e.equals(e.toLowerCase())).forEach(e-> System.out.println(e));
    }

}
