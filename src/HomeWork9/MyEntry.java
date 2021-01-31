package HomeWork9;

public class MyEntry<E> {
    public E value;
    public MyEntry<E> prev;
    public MyEntry<E> next;

    public MyEntry(E value, MyEntry<E> prev, MyEntry<E> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}
