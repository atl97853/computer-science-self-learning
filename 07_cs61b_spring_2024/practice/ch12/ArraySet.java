import java.util.Iterator;

/** We put our ArraySet in the inheritance hierarchy of the iterable interface 
 * and our iteration will work. 
 */
public class ArraySet<T> implements Iterable<T>{

    private T[] items;
    private int size; // invariant, the next item to be added will be at position size. 

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0; 
    }
    public int size() {
        return size;
    }
    public boolean contains(T o) {
        for (int i = 0; i < size; i += 1) {
            if (o.equals(items[i])) {
                return true;
            }
        }
        return false;
    }
    public void add(T e) {
        if (e == null) {
            throw new IllegalArgumentException("Cannot add null!");
        }
        if (contains(e)) {
           return;
        }
        items[size] = e;
        size += 1;
    }
    /** All we have to do is return an instance of our ArraySetIterator that we just wrote. */
    /** Returns an iterator (a.k.a. seer) into Me. */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }
    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;
        public ArraySetIterator() {
            wizPos = 0;
        }
        public boolean hasNext() {
            return wizPos < size;
        }
        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }

    @Override
    public String toString() {
        return this.toString();
    }

}
