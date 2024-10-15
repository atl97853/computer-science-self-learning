import edu.princeton.cs.algs4.In;

/**
 * Try to build an ArrList class that supports addLast, getLast, get, and size operations.
 * Your ArrList should work for any size array up to 100. For starter code, see
 * https://github.com/Berkeley-CS61B/lectureCode/tree/master/lists4/DIY.
 *
 * ArrList supports any data type using generics ??? first version using ints refactor later
 * */

public class ArrList <Cheese> {

    private int size;
    private Cheese[] arr;

    /** Creates an empty list. */
    public ArrList() {
        arr = (Cheese []) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Cheese x) {
        try {
            arr[size] = x;
            size++;
        }
        catch (Exception ArrayIndexOutOfBoundsException) {
            Cheese[] a = (Cheese []) new Object[size * 2];
            System.arraycopy(arr, 0, a, 0, size);
            arr = a;
            a[size] = x;
            size++;
        }
    }

    /** Returns the item from the back of the list. */
    public Cheese getLast() {
        return arr[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Cheese get(int index) {
        return arr[index];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Cheese removeLast() {
        Cheese deletedItem = arr[size - 1];
        arr[size - 1] = null;
        size--;
        return deletedItem;
    }
}