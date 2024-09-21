/**
 * Several exercises about reviewing recursive methods 
 * 
 * 1.1.16 Give the value of exR1(6): 
 * 
 * 1.1.17 Criticize the following recursive function:
 * 
 * 1.1.18 Consider the following recursive function:
 * What are the values of mystery(2, 25) and mystery(3, 11)? 
 * Given positive integers a and b, describe what value mystery(a, b) computes. 
 * Answer the same question, but replace + with * and replace return 0 with return 1.
 * 
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

public class recursiveMethods {

    // 1.1.16
    public static String exR1(int n) { 
            if (n <= 0) return "";
            return exR1(n - 3) + n + exR1(n - 2) + n;
        }

    // 1.1.17
    // The method creates an infinite loop, the base case will never be reached and the recursive calls will never end. 
    // An run-time error occurs. 
    public static String exR2(int n) {
            String s = exR2(n - 3) + n + exR2(n - 2) + n;
            if (n <= 0) return "";
            return s;
        }
    
    // 1.1.18
    public static int mystery(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery(a*a, b/2 );
        return mystery(a*a, b/2) * a;
    }

    
    public static void main(String[] args) {
        StdOut.println(mystery(2,25));
        StdOut.println(mystery(3,11));
    }

}