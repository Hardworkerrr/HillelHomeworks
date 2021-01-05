package HomeWork8;

public class MainProgram {
    public static void main(String[] args) {
        Collection<String> collection = new Collection<>("first second third fifth sixth nine");
        System.out.println(collection.toString());
        collection.add("Added1");
        System.out.println(collection.toString());
        collection.add(1,"Added2");
        System.out.println(collection.toString());
        collection.remove(1);
        System.out.println(collection.toString());
        collection.remove("Added1");
        System.out.println(collection.remove("Added1"));
        System.out.println(collection.toString());
        System.out.println(collection.get(3));
        System.out.println(collection.contain("Dog"));
        System.out.println(collection.contain("sixth"));
        System.out.println("Сравнение коллекций : ");
        Collection<String> collection2 = new Collection<>("first second third fifth sixth nine");
        Collection<String> collection3 = new Collection<>("first second third fifth sixth eight");
        System.out.println(collection.equals(collection2));
        System.out.println(collection.equals(collection3));
        collection.clear();
        System.out.println("Finished");


    }
}
