import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{

    /* Each node is composed with the structure [<- prev - item - next ->]. */
    /* The class should be private, but for testing usage is going to be public. */
    public class Node {
        public T item;
        public Node next;
        public Node prev;
        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    /* Dummy node, it doesn't store any values */
    /* The instance variable size should be private, but for testing usage is going to be public. */
    public Node sentinel;
    public int size;

//    public LinkedListDeque61B(T item) {
//        sentinel = new Node(null, null, null); // creates "dummy node".
//        sentinel.next = new Node(item, sentinel, sentinel); // the node after sentinel, creates the first node of the list.
//        sentinel.prev = sentinel.next; // the node before sentinel is the last node in the list.
//    }
    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null); // creates "dummy node".
        sentinel.next = sentinel; // .next points to the sentinel itself, recursively the next node after sentinel.
        sentinel.prev = sentinel; // .prev points to the sentinel itself, recursively the last node in the list.
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev = new Node(x, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel.next;
        /* Scan p until it recursively returns to sentinel, its item's value is equal to null,
        // it takes linear time O(n). */
        while (p.item != null) {
            returnList.add(p.item);
            p = p.next;
        }
        return returnList;
        //return List.of();
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    /* The first item is always going to be after the sentinel, in sentinel.next. */
    public T removeFirst() {
        if (size <= 0) return null;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel; //
        size -= 1;
        return null;
    }

    @Override
    /* The last item is always going to be before the sentinel, in sentinel.prev. */
    public T removeLast() {
        if (size <= 0) return null;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return null;
    }

    @Override
    public T get(int index) {
        //if (index > size || index <= 0) return null;
        int low = 1;
        int high = size;
        int mid = size / 2;
        /* Time complexity O(n/2) = O(0.5 * n) = O(n). */
        /*The index is between low and mid. */
        if (index >= low && index <= mid) {
            Node p = sentinel.next;
            int count = low; // count starts at low an increases until it is equal to index.
            while (index != count) {
                p = p.next;
                count++;
            }
            return p.item;
        }
        /* The index is between mid and high. */
        if (index >= mid && index <= high) {
            Node p = sentinel.prev;
            int count = size; // count starts at high and decreases until it is equal to index.
            while (index != count) {
                p = p.prev;
                count--;
            }
            return p.item;
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if (index > size || index <= 0) return null; // this just makes sure index is not out of the list range.
        Node p = sentinel.next;
        int count = 1; // there isn't index 0, it starts with 1, index 0 could be sentinel.
        return helper(p, index, count);
    }

    /* Secret recursive language of the gods. */
    private T helper(Node p, int index, int count) {
        if (index == count) {
            return p.item;
        }
        // System.out.println("execute");
        return helper(p.next, index, ++count);
    }
}
