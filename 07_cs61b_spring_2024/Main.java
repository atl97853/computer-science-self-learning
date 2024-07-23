// Exercise 1.1.2
/**
 * Modify Main so that it prints out the cumulative sum 
 * of the integers from 0 to 9. For example, your output should start 
 * with 0 1 3 6 10... and should end with 45. 
*/
public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        while (x < 10) {
            System.out.print(y + " ");
            x = x + 1;
            y = y + x;
        }
    }
}

// Exercises 1.4
/**
 * True/False: All variables, parameters, and methods must have a declared type in Java, and the type can never change.
 * Suppose we have a function smaller(a, b) that takes in two int arguments a and b and returns the smaller of the two. What would the expression String x = smaller(10, 20) + 3; output?
 * Choose all statements that are true in Java: 
    * All code must be part of a class.
    * The end and beginning of code segments are delimited using curly brackets {}. 
    * All statements in Java end with a semi-colon ;.Any code we want to run must be inside of a function public static void main(String[] args). 
 */
public class Main {
    private static String smaller(final int a, final int b) {
        int smallerNumber;
        if (a < b) {
            smallerNumber = a;
        } else {
            smallerNumber = b;
        }
        return smallerNumber + " ";
    }
    public static void main(String[] args) {
        String x = smaller(10, 20) + 3;
        System.out.println(x);
    }
}