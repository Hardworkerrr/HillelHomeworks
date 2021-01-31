package HomeWork9;
public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> str = new MyLinkedList<>();
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        str.add("e");
        str.add("g");
        System.out.println("=====================");
        System.out.println("After adding:");
        str.check();
        System.out.println("=====================");
        str.addAll(new String[]{"1arrayword","2arrayword"});
        System.out.println("After adding String array:");
        str.check();
        MyLinkedList<String> str1 = new MyLinkedList<>();
        str1.add("1word");
        str1.add("2word");
        str1.add("3word");
        System.out.println("=====================");
        System.out.println("New collection: ");
        str1.check();
        str.addAll(str1);
        System.out.println("=====================");
        System.out.println("After adding new collection: ");
        str.check();
        str.delete(6);
        System.out.println("=====================");
        System.out.println("After delete by index: ");
        str.check();
        System.out.println("=====================");
        str.delete("1word");
        System.out.println("After delete by value: ");
        str.check();
        System.out.println("=====================");
        System.out.println("Get:");
        System.out.println(str.get(8));
        System.out.println("=====================");
        System.out.println("Contains: ");
        System.out.println(str.contains("3word"));
        System.out.println(str.contains("4word"));
        System.out.println("=====================");
        System.out.println("After deleting : ");
        str.clear();
        str.check();
        System.out.println("=====================");
        System.out.println("Comparing two collections :");
        MyLinkedList<String> str3 = new MyLinkedList<>();
        str3.addAll(new String[]{"0","1","2","5"});
        MyLinkedList<String> str4 = new MyLinkedList<>();
        str4.addAll(new String[]{"0","1","2","5"});
        MyLinkedList<String> str5 = new MyLinkedList<>();
        str5.addAll(new String[]{"0","1","3","4"});
        System.out.println(str3.compare(str4));
        System.out.println(str3.compare(str5));



    }
}
