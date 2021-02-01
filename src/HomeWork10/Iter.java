package HomeWork10;

public class Iter<E> {

    private E[] array;
    private int size;
    private int start;

    public Iter(int size, E[] array){
      this.size=size;
      this.array=array;
    }

    public boolean hasNext(){
        return start<size;
    }

    public E next(){
        start++;
        return array[start-1];
    }

    public void startAgain(){
        start=0;
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove item from array.");
    }

}
