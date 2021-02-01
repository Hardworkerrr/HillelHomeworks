package HomeWork10;

import java.util.ArrayList;

public class NoDuplicate {
    public static void main(String[] args) {
        ArrayList<String> coll = new ArrayList<>();
        coll.add("a");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("h");
        coll.add("h");
        coll.add("h");
        coll.add("h");
        coll.add("h");
        coll.add("h");
        coll.add("h");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("b");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        coll.add("a");
        System.out.println(coll.toString());
        System.out.println("=================");
        no_duplicate(coll);
        System.out.println(coll.toString());
    }

    static void no_duplicate(ArrayList<?> collection) {
        for (int i = 0; i < collection.size(); i++)
            for (int j = 0; j < collection.size(); j++) {
                if (collection.get(i) == collection.get(j) && i != j) {
                    collection.remove(j);
                    j--;
                }
            }
    }
}
