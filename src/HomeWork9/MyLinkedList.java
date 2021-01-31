package HomeWork9;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;

public class MyLinkedList<E> implements CustomCollection<E> {
    public int size = 0;
    public MyEntry<E> first;
    public MyEntry<E> last;


    public MyLinkedList() {
        this.first = new MyEntry<>(null, null, null);
        this.last = new MyEntry<>(null, null, null);
    }


    @Override
    public boolean add(E str) {
        MyEntry<E> link = new MyEntry<>(str, last, first);
        if (first.next == null)
            first = link;
        last = link;
        link.prev.next = link;
        link.next.prev = link;
        size++;
        return true;
    }

    public void check() {
        MyEntry<E> newLink = first;
        for (int i = 0; i < size; i++) {
            System.out.println(newLink.value);
            newLink = newLink.next;
        }
    }

    @Override
    public boolean addAll(E[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            this.add(strArr[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(MyLinkedList<E> strColl) {
        String[] collection = new String[strColl.size()];
        MyEntry<E> newLink = strColl.first;
        for (int i = 0; i < collection.length; i++) {
            collection[i] = (String) newLink.value;
            newLink = newLink.next;
            this.add((E) collection[i]);
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        MyEntry<E> newLink = first;
        if (index >= size) {
            System.out.println("Error, index>=size");
            return false;
        }
        if (index == 0) {
            first = newLink.next;
        }
        for (int i = 0; i < index; i++) {
            newLink = newLink.next;
        }
        newLink.prev.next = newLink.next;
        newLink.next.prev = newLink.next;
        size--;
        return true;
    }

    @Override
    public boolean delete(String str) {
        MyEntry<E> newLink = first;
        for (int i = 0; i < size; i++) {
            if (newLink.value == str) {
                this.delete(i);
                break;
            } else
                newLink = newLink.next;
        }
        return true;
    }

    @Override
    public E get(int index) {
        MyEntry<E> newLink = first;
        if (index >= size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            newLink = newLink.next;
        }
        return newLink.value;
    }

    @Override
    public boolean contains(String str) {
        MyEntry<E> newLink = first;
        for (int i = 0; i < size; i++) {
            if (newLink.value == str) {
                return true;
            } else
                newLink = newLink.next;
        }
        return false;
    }

    @Override
    public boolean clear() {
        first = null;
        last = null;
        size = 0;
        System.out.println("Cleared...");
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean trim() {
        return false;
    }

    @Override
    public boolean compare(MyLinkedList<E> coll) {
        MyEntry<E> coll1Link = first;
        MyEntry<E> coll2Link = coll.first;
        if (this.size != coll.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (coll1Link.value == coll2Link.value) {
                coll1Link = coll1Link.next;
                coll2Link = coll2Link.next;
            } else
                return false;
        }
        return true;
    }

    public E getFirst() {
        MyEntry<E> entry = first;
        return entry.value;
    }

    public E getLast() {
        return last.value;
    }
}
