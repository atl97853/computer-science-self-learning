import java.util.*;

public class Main  {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        // stack.push(17); // autoboxing
        // System.out.println(stack);
        // Integer next = stack.pop(); // unboxing
        // System.out.println(next);

        for (int i = 0; i <= 10; i++) {
            stack.push(i);
            // System.out.println(i);
        }
        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}