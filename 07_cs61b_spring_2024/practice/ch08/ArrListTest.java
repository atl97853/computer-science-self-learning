import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/** Tests the ArrList class.
 *  @author Josh Hug
 */

public class ArrListTest {
    @Test
    public void testEmptySize() {
        ArrList L = new ArrList();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        ArrList L = new ArrList();
        L.addLast(99);
        L.addLast(99);
        assertEquals(2, L.size());
    }


    @Test
    public void testAddAndGetLast() {
        ArrList L = new ArrList();
        L.addLast(99);
        assertEquals(99, L.getLast());
        L.addLast(36);
        assertEquals(36, L.getLast());
    }


    @Test
    public void testGet() {
        ArrList L = new ArrList();
        L.addLast(99);
        assertEquals(99, L.get(0));
        L.addLast(36);
        assertEquals(99, L.get(0));
        assertEquals(36, L.get(1));
    }


    @Test
    public void testRemove() {
        ArrList L = new ArrList();
        L.addLast(99);
        assertEquals(99, L.get(0));
        L.addLast(36);
        assertEquals(99, L.get(0));
        L.removeLast();
        assertEquals(99, L.getLast());
        L.addLast(100);
        assertEquals(100, L.getLast());
        assertEquals(2, L.size());
    }

    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        ArrList L = new ArrList();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }

    @Test
    public void testMegaGet() {
        ArrList L = new ArrList();
        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            if (i == 33456) {
                L.addLast(99999);
            }
            L.addLast(i);
        }
        assertEquals(99999, L.get(33456));
    }
}