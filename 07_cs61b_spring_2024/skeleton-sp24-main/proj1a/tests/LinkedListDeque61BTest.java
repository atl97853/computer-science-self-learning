import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    @Test
    /** In this test, we have three different assert statements that verify that addFirst works correctly. */
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
    }

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    // Below, you'll write your own tests for LinkedListDeque61B.

    @Test
    /** This tests .adFirst with only one element. */
    public void addFirstTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(3);
        assertThat(L.toList()).containsExactly(3).inOrder();
    }

    @Test
    /** This tests .addFirst with several elements and checks if they are sorted as expected. */
    public void addFirstTest02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(5);
        L.addFirst(10);
        L.addFirst(15);
        L.addFirst(20);
        assertThat(L.toList()).containsExactly(20, 15, 10, 5).inOrder();
    }

    @Test
    /** This test .addFirst and .toList adding 500 elements. */
    public void addFirstTest03() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        List<Integer> E = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            E.add(500 - (i + 1));
            L.addFirst(i);
        }
        assertThat(L.toList())
                .containsExactlyElementsIn(E)  // `expected` is a List
                .inOrder();
    }

    @Test
    /** This test checks if .addLast adds items to the back of the deque in sorted as expected. */
    public void addLastTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(5);
        L.addLast(10);
        L.addLast(15);
        L.addLast(20);
        assertThat(L.toList()).containsExactly(5, 10, 15, 20).inOrder();
    }

    @Test
    /** This test checks if .addFirst and addLast work together as expected */
    public void addFirstAndLastTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        L.addFirst(5);
        L.addLast(20);
        L.addLast(25);
        assertThat(L.toList()).containsExactly(5, 10, 20, 25).inOrder();
    }

    @Test
    /** This test checks if .addFirst and addLast work together as expected */
    public void addFirstAndLastTest02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(5);
        L.addLast(9);
        L.addLast(10);
        L.addFirst(3);
        assertThat(L.toList()).containsExactly(3, 5, 9, 10).inOrder();
    }

    @Test
    /** This creates a new empty list and helps to check if .next and .prev point
     * at the sentinel itself when the constructor is invoked. */
    public void constructorEmptyListTest() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .toList with an empty list, and extra test using .isEmpty. */
    public void toListTest01() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        assertThat(L.toList())
                .containsExactly()
                .inOrder();
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .toList with several elements. */
    public void toListTest02() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        L.addFirst("whats");
        L.addLast("the");
        L.addLast("dog");
        L.addLast("doing");
        assertThat(L.toList())
                .containsExactly("whats", "the", "dog", "doing")
                .inOrder();
    }

    @Test
    /** This tests .isEmpty with an empty list. */
    public void isEmptyTest01() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .isEmpty with a non-empty list. */
    public void isEmptyTest02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        assertThat(L.isEmpty()).isFalse();
    }

    @Test
    /** This checks if the list can store 50,000,000 elements using .addFirst. */
    public void sizeTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 50000000;
        for (int i = 0; i < numElements; i++) {
            L.addFirst(i);
        }
        assertWithMessage("50,000,000 elements were added to the list")
                .that(L.size())
                .isEqualTo(numElements);
        assertThat(L.sentinel.prev.item).isEqualTo(0);
        assertThat(L.sentinel.next.item).isEqualTo(numElements - 1);
    }

    @Test
    /** This checks if the list can store 50,000,000 elements using .addLast. */
    public void sizeTest02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 50000000;
        for (int i = 0; i < numElements; i++) {
            L.addLast(i);
        }
        assertWithMessage("50,000,000 elements were added to the list")
                .that(L.size())
                .isEqualTo(numElements);
        assertThat(L.sentinel.prev.item).isEqualTo(numElements - 1);
        assertThat(L.sentinel.next.item).isEqualTo(0);
    }

    /* Tests for the reaming methods up to this point. */
    @Test
    /** This tests .removeFirst and .isEmpty, adding one element, removing it, and checking if the list is empty. */
    public void removeFirstAndIsEmptyTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        L.removeFirst();
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .removeLast and .isEmpty, adding one element, removing it, and checking if the list is empty. */
    public void removeFirstAndIsEmptyTest02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(10);
        L.removeLast();
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .removeFirst using a list with several elements and calling .removeFirst once. */
    public void removeFirsTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(20);
        L.addFirst(10);
        L.addFirst(500);
        L.addLast(30);
        L.removeFirst();
        assertThat(L.toList())
                .containsExactly(10, 20, 30)
                .inOrder();
    }

    @Test
    /** This tests .removeFirst adding several elements and deleting them all, the test expects an empty list. */
    public void removeFirsTest02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 500;
        for (int i = 0; i < numElements; i++) {
            L.addFirst(i);
        }
        for (int i = 0; i < numElements; i++) {
            L.removeFirst();
        }
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .removeLast, calling the method several times after adding an element using .addLast. */
    public void removeLast01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(5);
        L.addLast(123);
        L.removeLast();
        L.addFirst(10);
        L.addLast(123);
        L.removeLast();
        L.addFirst(15);
        L.addLast(123);
        L.removeLast();
        L.addFirst(20);
        L.addLast(123);
        L.removeLast();
        assertThat(L.toList())
                .containsExactly(20, 15, 10, 5)
                .inOrder();
    }

    @Test
    /** This tests .removeLast adding several elements using a for loop and deleting them all expecting an empty list. */
    public void removeLast02() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 500;
        for (int i = 0; i < numElements; i++) {
            L.addLast(i);
        }
        for (int i = 0; i < numElements; i++) {
            L.removeLast();
        }
        assertThat(L.isEmpty()).isTrue();
    }

    @Test
    /** This tests .removeLast using a list with several elements and calling .removeLast once. */
    public void removeLast03() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(20);
        L.addFirst(10);
        L.addLast(30);
        L.addLast(500);
        L.removeLast();
        assertThat(L.toList())
                .containsExactly(10, 20, 30)
                .inOrder();
    }

    @Test
    /** This empty list should return null because .get is having an index out of the bounds. */
    public void getTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.get(100)).isEqualTo(null);
    }

    @Test
    /** This tests that .get returns the first item of the list in a list with only one item. */
    public void getTest02() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        L.addFirst("Hello");
        assertThat(L.get(1)).isEqualTo("Hello");
    }

    @Test
    /** This empty list should return null because .get is having a negative index out of the bounds. */
    public void getTest03() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.get(-1)).isEqualTo(null);
    }

    @Test
    /** This tests .get to return the second element of a list. */
    public void getTest04() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(10);
        L.addFirst(5);
        L.addFirst(10);
        assertThat(L.get(2)).isEqualTo(5);
    }

    @Test
    /** This test .get three times in a list with 50,000,000 elements,
     * it gets the last, first and middle element of the list. */
    public void getTest05() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 50000000;
        for (int i = 0; i < numElements; i++) {
            L.addLast(i);
        }
        assertThat(L.get(numElements)).isEqualTo(numElements - 1); // last element of the list.
        assertThat(L.get(1)).isEqualTo(0); // first element of the list.
        assertThat(L.get(numElements / 2)).isEqualTo((numElements - 1) / 2); // middle element of the list.
    }

    @Test
    /** This tests .get getting multiple items in different positions in the same list. */
    public void getTest06() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 500;
        for (int i = 1; i < numElements; i++) {
            L.addLast(i);
        }
        assertThat(L.get(0)).isEqualTo(null);
        assertThat(L.get(1)).isEqualTo(1);
        assertThat(L.get(234)).isEqualTo(234);
        assertThat(L.get(250)).isEqualTo(250);
        assertThat(L.get(499)).isEqualTo(499);
        assertThat(L.get(50)).isEqualTo(50);

    }

    @Test
    /** This empty list should return null because .getRecursive is having an index out of the bounds. */
    public void getRecursiveTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.getRecursive(100)).isEqualTo(null);
    }

    @Test
    /** This tests that .getRecursive returns the first item of the list in a list with only one item. */
    public void getRecursiveTest02() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        L.addFirst("Hello");
        assertThat(L.getRecursive(1)).isEqualTo("Hello");
    }

    @Test
    /** This empty list should return null because .getRecursive is having a negative index out of the bounds. */
    public void getRecursiveTest03() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.getRecursive(-1)).isEqualTo(null);
    }

    @Test
    /** This tests .getRecursive to return the second element of a list. */
    public void getRecursiveTest04() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(10);
        L.addFirst(5);
        L.addFirst(10);
        assertThat(L.getRecursive(2)).isEqualTo(5);
    }

    //    @Test
//    /** This test .getRecursive three times in a list with 50,000,000 elements,
//     * it gets the last, first and middle element of the list. */
//    // note, because this method is recursive, and we are not using O(n/2) but O(n)
//    // this test returns StackOverflowError, too many recursive calls for this method, tuns out into overhead.
//    public void getRecursiveTest05() {
//        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
//        int numElements = 50000000;
//        for (int i = 0; i < numElements; i++) {
//            L.addLast(i);
//        }
//        assertThat(L.getRecursive(numElements)).isEqualTo(numElements - 1); // last element of the list.
//        assertThat(L.getRecursive(1)).isEqualTo(0); // first element of the list.
//        assertThat(L.getRecursive(numElements/2)).isEqualTo((numElements - 1)/2); // middle element of the list.
//    }
    @Test
    /** This tests .getRecursive getting multiple items in different positions in the same list. */
    public void getRecursiveTest06() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        int numElements = 500;
        for (int i = 1; i < numElements; i++) {
            L.addLast(i);
        }
        assertThat(L.getRecursive(0)).isEqualTo(null);
        assertThat(L.getRecursive(1)).isEqualTo(1);
        assertThat(L.getRecursive(234)).isEqualTo(234);
        assertThat(L.getRecursive(250)).isEqualTo(250);
        assertThat(L.getRecursive(499)).isEqualTo(499);
        assertThat(L.getRecursive(50)).isEqualTo(50);

    }

    /* Checking all the methods in one test. */
    @Test
    /**/
    public void allTest01() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        L.addLast(20);
        L.removeFirst();
        L.removeLast();
        assertThat(L.isEmpty()).isTrue();
        L.addLast(10);
        L.addFirst(10);
        assertThat(L.isEmpty()).isFalse();
        assertThat(L.toList()).containsExactly(10, 10).inOrder();
        L.removeLast();
        assertThat(L.get(1)).isEqualTo(10);
        L.removeFirst();
        assertThat(L.get(1)).isEqualTo(null);
    }

    /** Coverage Tests - Project 1A: Linked List Deque 61B. */
    /**
     * Flags for add tests.
     */
    @Test
    /** “add_first_from_empty”: Check that addFirst works on an empty deque. */
    public void add_first_from_empty() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        L.addFirst("Hello");
        assertThat(L.toList()).containsExactly("Hello").inOrder();
    }

    @Test
    /** “add_last_from_empty”: Check that addLast works on an empty deque. */
    public void add_last_from_empty() {
        LinkedListDeque61B<String> L = new LinkedListDeque61B<>();
        L.addLast("Hello");
        assertThat(L.toList()).containsExactly("Hello").inOrder();
    }

    @Test
    /** “add_first_nonempty”: Check that addFirst works on a non-empty deque. */
    public void add_first_nonempty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        L.addFirst(20);
        assertThat(L.toList()).containsExactly(20, 10).inOrder();
    }

    @Test
    /** “add_last_nonempty”: Check that addLast works on a non-empty deque. */
    public void add_last_nonempty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(10);
        L.addLast(20);
        assertThat(L.toList()).containsExactly(10, 20).inOrder();
    }

    /**
     * Flags for add after remove tests.
     */
    @Test
    /** “add_first_after_remove_to_empty”: Add some elements to a deque and remove them all,
     * then check that addFirst still works. */
    public void add_first_after_remove_to_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addFirst(i);
        }
        for (int i = 1; i < 50; i++) {
            L.removeFirst();
        }
        assertThat(L.toList()).isEmpty();
        L.addFirst(10);
        assertThat(L.toList()).containsExactly(10).inOrder();
    }
    @Test
    /** “add_last_after_remove_to_empty”: Add some elements to a deque and remove them all,
     * then check that addLast still works. */
    public void add_last_after_remove_to_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addLast(i);
        }
        for (int i = 1; i < 50; i++) {
            L.removeLast();
        }
        assertThat(L.toList()).isEmpty();
        L.addLast(10);
        assertThat(L.toList()).containsExactly(10).inOrder();
    }
    /** Flags for remove tests. */
    @Test
    /** “remove_first”: Check that removeFirst works. */
    public void remove_first() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        L.addFirst(20);
        L.addFirst(30);
        L.removeFirst();
        assertThat(L.toList()).containsExactly(20, 10).inOrder();
    }
    @Test
    /** “remove_last”: Check that removeLast works. */
    public void remove_last() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(10);
        L.addLast(20);
        L.addLast(30);
        L.removeLast();
        assertThat(L.toList()).containsExactly(10, 20).inOrder();
    }
    @Test
    /** “remove_first_to_empty”: Add some elements to a deque and remove almost all of them.
     * Check that removing the last element with removeFirst works. */
    public void remove_first_to_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addFirst(i);
        }
        for (int i = 1; i < 49; i++) {
            L.removeLast();
        }
        L.removeFirst();
        assertThat(L.toList()).isEmpty();
    }
    @Test
    /** “remove_last_to_empty”: Add some elements to a deque and remove almost all of them.
     * Check that removing the last element with removeLast works. */
    public void remove_last_to_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addLast(i);
        }
        for (int i = 1; i < 49; i++) {
            L.removeFirst();
        }
        L.removeLast();
        assertThat(L.toList()).isEmpty();
    }
    @Test
    /**  “remove_first_to_one”: Add some elements to a deque and remove almost all of them.
     * Check that removing the second to last element with removeFirst works.*/
    public void remove_first_to_one() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(10);
        L.addFirst(20);
        L.addFirst(30);
        L.removeFirst();
        L.removeFirst();
        assertThat(L.toList()).containsExactly(10).inOrder();
    }
    @Test
    /**  “remove_last_to_one”: Add some elements to a deque and remove almost all of them.
     * Check that removing the second to last element with removeLast works.*/
    public void remove_last_to_one() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(10);
        L.addLast(20);
        L.addLast(30);
        L.removeLast();
        L.removeLast();
        assertThat(L.toList()).containsExactly(10).inOrder();
    }
    /** Flags for get tests. */
    @Test
    /** “get_valid”: Check that get works on a valid index. */
    public void get_valid() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addLast(i);
        }
        assertThat(L.get(25)).isEqualTo(25);
    }
    @Test
    /** “get_oob_large”: Check that get works on a large, out of bounds index. */
    public void get_oob_large() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.get(1000000)).isEqualTo(null);
    }
    @Test
    /** “get_oob_neg”: Check that get works on a negative index. */
    public void get_oob_neg() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.get(-1000000)).isEqualTo(null);
    }
    @Test
    /** “get_recursive_valid”: Check that getRecursive works on a valid index. */
    public void get_recursive_valid() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addLast(i);
        }
        assertThat(L.getRecursive(25)).isEqualTo(25);
    }
    @Test
    /** “get_recursive_oob_large”: Check that getRecursive works on a large, out of bounds index. */
    public void get_recursive_oob_large() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.getRecursive(1000000)).isEqualTo(null);
    }
    @Test
    /** “get_recursive_oob_neg”: Check that getRecursive works on a negative index. */
    public void get_recursive_oob_neg() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.getRecursive(-1000000)).isEqualTo(null);
    }
    /** Flags for size tests. */
    @Test
    /** “size”: Check that size works. */
    public void size() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 0; i < 50; i++) {
            L.addLast(i);
        }
        assertThat(L.size()).isEqualTo(50);
    }
    @Test
    /** “size_after_remove_to_empty”: Add some elements to a deque and remove them all,
     * then check that size still works. */
    public void size_after_remove_to_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        for (int i = 1; i < 50; i++) {
            L.addLast(i);
        }
        for (int i = 1; i < 50; i++) {
            L.removeFirst();
        }
        assertThat(L.size()).isEqualTo(0);
    }
    @Test
    /** “size_after_remove_from_empty”: Remove from an empty deque, then check that size still works. */
    public void size_after_remove_from_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.removeFirst();
        L.removeLast();
        assertThat(L.size()).isEqualTo(0);
    }
    /** Flag for isEmpty tests. */
    @Test
    /** “is_empty_true”: Check that isEmpty works on an empty deque. */
    public void is_empty_true() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.isEmpty()).isTrue();
    }
    @Test
    /** “is_empty_false”: Check that isEmpty works on a non-empty deque. */
    public void is_empty_false() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addLast(20);
        L.addFirst(10);
        assertThat(L.isEmpty()).isFalse();
    }
    /** Flags for toLists tests. */
    @Test
    /** “to_list_empty”: Check that toList works with empty LinkedListDeque61B. */
    public void to_list_empty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        assertThat(L.toList()).containsExactly().inOrder();
    }
    @Test
    /** “to_list_nonempty”: Check that toList works with non-empty LinkedListDeque61B. */
    public void to_list_nonempty() {
        LinkedListDeque61B<Integer> L = new LinkedListDeque61B<>();
        L.addFirst(20);
        L.addLast(10);
        assertThat(L.toList()).containsExactly(20, 10).inOrder();
    }





}