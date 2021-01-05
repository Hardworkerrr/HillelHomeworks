package HomeWork8;

import java.util.Arrays;

public class Collection<E> implements NewCollection<E> {
    private int elementsSize = 0;
    private final int DEFAULT_CAPACITY = 7;
    private int newCapacity = 0;
    private Object[] Coll;

    public Collection() {
        Coll = new String[DEFAULT_CAPACITY];
    }

    public Collection(String str) {
        Coll = new String[DEFAULT_CAPACITY];
        String[] newStr = str.split(" ");
        if (newStr.length >= DEFAULT_CAPACITY) {
            newCapacity = (int) (newStr.length * (3.0 / 2.0) + 1);
            Coll = new String[newCapacity];
            Coll = Arrays.copyOf(newStr, newCapacity);
        } else {
            Coll = Arrays.copyOf(newStr, DEFAULT_CAPACITY);
        }
        elementsSize = newStr.length;
    }

    @Override
    public boolean add(E o) {
        elementsSize++;
        if (elementsSize >= newCapacity) {
            newCapacity = (int) (Coll.length * (3.0 / 2.0) + 1);
            Coll = Arrays.copyOf(Coll, newCapacity);
        }
        Coll[elementsSize - 1] = o;
        return true;
    }

    @Override
    public boolean add(int index, E o) {
        elementsSize++;
        if (elementsSize >= newCapacity) {
            newCapacity = (int) (Coll.length * (3.0 / 2.0) + 1);
            Coll = Arrays.copyOf(Coll, newCapacity);
        }
        for (int i = elementsSize - 1; i > index; i--) {
            Coll[i] = Coll[i - 1];
        }
        Coll[index] = o;
        return true;
    }

    @Override
    public boolean remove(int index) {
        elementsSize--;
        Coll[index] = null;
        for (int i = index; i <= elementsSize; i++) {
            Coll[i] = Coll[i + 1];
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i <= elementsSize; i++) {
            if (Coll[i] == o) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        return (E) Coll[index];
    }

    @Override
    public boolean contain(E o) {
        for (int i = 0; i < elementsSize; i++) {
            if (Coll[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(NewCollection o) {
        boolean equals = false;
        if (this.elementsSize < o.size()) {
            return false;
        }
        for (int i = 0; i < elementsSize; i++) {
            if (Coll[i].equals(o.get(i))) {
                equals = true;
            } else return false;
        }
        return equals;
    }

    @Override
    public boolean clear() {
        elementsSize = 0;
        Coll = new Object[DEFAULT_CAPACITY];
        return true;
    }

    @Override
    public int size() {
        return elementsSize;
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < elementsSize; i++) {
            if (i == elementsSize - 1) {
                str += Coll[i] + "]";
                break;
            }
            str += Coll[i] + ", ";
        }
        return str;
    }

}
