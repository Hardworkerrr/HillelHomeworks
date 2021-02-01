package HomeWork10;

public class Main {
    public static void main(String[] args) {
        String[] array = {"A","B","C","CHECK","D"};
        Iter<String> iter= new Iter<>(array.length,array);
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("====================");
        iter.startAgain();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(iter.hasNext());
    }
}
