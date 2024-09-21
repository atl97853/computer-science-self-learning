/**
 * 1.1.19 Run the following program on your computer:
 * What is the largest value of N for which this program takes less 1 hour to compute the value of F(N)? 
 * Develop a better implementation of F(N) that saves computed values in an array.
 * Fibonacci. 
 * 
 * Memoization - Fibonacci
 */https://medium.com/outco/how-to-implement-memoization-in-3-simple-steps-83758b2439a

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

public class ex_1_1_19 {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }

    public static int test(int N) {
        if (N <= 0) {
            return N;
        }
        return test(N - 1);
    }

    public static void main(String[] args) {
        // for (int N = 0; N < 100; N++) {
        //     StdOut.println(N + " " + F(N));
        // }
        // StdOut.println(F(5));

        StdOut.println(test(10));
        

    }
}