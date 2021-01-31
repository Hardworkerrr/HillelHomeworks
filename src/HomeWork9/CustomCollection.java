package HomeWork9;

public interface CustomCollection<E> {
    boolean add(E str);

    boolean addAll(E[] strArr);

    boolean addAll(MyLinkedList<E> strColl);

    boolean delete(int index);

    boolean delete(String str);

    E get(int index);

    boolean contains(String str);

    boolean clear();

    int size();

    boolean trim();

    boolean compare(MyLinkedList<E> coll);
}
