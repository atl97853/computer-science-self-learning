import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
            .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
            .toList();

        assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    }
    /* Flags for toList tests. */
    @Test
    @DisplayName("Check that toList works with empty ArrayDeque")
    public void to_list_empty() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        assertThat(da.toList()).containsExactly().inOrder();
    }
    @Test
    @DisplayName("Check that toList works with non-empty ArrayDeque")
    public void to_list_nonempty() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        da.addFirst("A");
        da.addLast("B");
        da.addFirst("C");
        assertThat(da.toList()).containsExactly("C","A","B").inOrder();
    }
    /* Flags for add tests. */
    @Test
    @DisplayName("Check that addFirst works on an empty deque")
    public void add_first_from_empty() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        assertThat(da.toList()).containsExactly().inOrder(); // checks empty list.
        da.addFirst("Hello World");
        assertThat(da.toList()).containsExactly("Hello World").inOrder(); // checks addFirst.
    }
    @Test
    @DisplayName("Check that addLast works on an empty deque")
    public void add_last_from_empty() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        assertThat(da.toList()).containsExactly().inOrder(); // checks empty list.
        da.addLast("Hello World");
        assertThat(da.toList()).containsExactly("Hello World").inOrder(); // checks addFirst.
    }
    @Test
    @DisplayName("Check that addFirst works on a non-empty deque")
    public void add_first_nonempty() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        da.addFirst("A");
        da.addFirst("B");
        assertThat(da.toList()).containsExactly("B","A").inOrder();
    }
    @Test
    @DisplayName("Check that addLast works on a non-empty deque")
    public void add_last_nonempty() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        da.addLast("C");
        da.addLast("D");
        assertThat(da.toList()).containsExactly("C","D").inOrder();
    }
    @Test
    @DisplayName("Check that addFirst works when called on a full underlying array")
    public void add_first_trigger_resize() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        da.addFirst("a");
        da.addFirst("a");
        da.addFirst("a");
        da.addFirst("a");
        da.addFirst("a");
        da.addFirst("a");
        da.addFirst("a");
        da.addFirst("a"); // the first initialized deque array is full, 8 items.
        assertThat(da.toList()) // checking the exact moment when the deque array is full.
                .containsExactly("a","a","a","a","a","a","a","a")
                .inOrder();
        da.addFirst("B"); // trigger resize and adds B at the head of the array, 9th item.
        assertThat(da.toList())
                .containsExactly("B","a","a","a","a","a","a","a","a")
                .inOrder();
    }
    @Test
    @DisplayName("Check that addLast works when called on a full underlying array")
    public void add_last_trigger_resize() {
        ArrayDeque61B<String> da = new ArrayDeque61B<>();
        da.addLast("x");
        da.addLast("x");
        da.addLast("x");
        da.addLast("x");
        da.addLast("x");
        da.addLast("x");
        da.addLast("x");
        da.addLast("x");
        assertThat(da.toList())
                .containsExactly("x","x","x","x","x","x","x","x")
                .inOrder(); // checking the exact moment when the deque array is full.
        da.addLast("W"); // trigger resize and adds W at the tail of the array, 9th item.
        assertThat(da.toList())
                .containsExactly("x","x","x","x","x","x","x","x", "W")
                .inOrder();
    }
//    @Test
//    @DisplayName("")
//    public void add_() {
//        ArrayDeque61B<String> da = new ArrayDeque61B<>();
//    }
}
