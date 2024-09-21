/**
 * 1.1.15 Write a static method histogram() that takes an array a[] of int values and an integer M as arguments 
 * and returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array
 * If the values in a[] are all between 0 and M−1, the sum of the values in the returned array should be equal to a.length
 * 
 * @param arr an array a[] of int values 
 * @param M integer 
 * @return returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array  
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

public class histogram {

    public static int[] histogram(int[] arr, int M) {

        int[] result = new int[M];
        int count = 0;
        for (int index = 0; index < arr.length; index++) {
            int i = arr[index];
            result[i] = result[i] + 1;
            count +=1;
            StdOut.println("Count " + count);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3,3};
        int[] b = histogram(a,6);
        StdOut.println(Arrays.toString(a));
        StdOut.println(Arrays.toString(b));
    }
    
}