package HomeWork8;

public interface NewCollection<E> {
    boolean add(E o);

    boolean add(int index, E o);

    boolean remove(int index);

    boolean remove(E o);

    E get(int index);

    boolean contain(E o);

    boolean equals(NewCollection o);

    boolean clear();

    int size();
}
