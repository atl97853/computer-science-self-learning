/**************************************************
 * Compilation: javac-algs4 Exercises.java 
 * Execution: java-algs4 Exercises
 * End execution: CTRL + D 
 * 
 * 
 * Several exercises from 1.1 chapter. 
***************************************************/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Arrays;

public class Exercises {
    /**
     * Method - 1.1.3 Write a program that takes three integer command-line arguments and prints 
     * equal if all three are equal, and not equal otherwise.
     * @param int a 
     * @param int b 
     * @param int c
     * @return String - "equal"/"not equal"
     * It needs to create an array to store the command-line given numbers, initialize the array using 
     * an index variable and a while loop to read the command-line input using StdIn.readInt() method. 
     * */
    public static String equalNotEqual(int a, int b, int c) {
        if (a == b && b == c) {
            return "equal";
        } 
        return "not equal";
    }

    /**
     * Method - 1.1.5 Write a code fragment that prints true if the double variables x and y are both strictly 
     * between 0 and 1 and false otherwise.
     * @param double x 
     * @param double y 
     * @return Boolean - true/false 
     * It needs to create an array to store the command-line given numbers, initialize the array using 
     * an index variable and a while loop to read the command-line input using StdIn.readDouble() method. 
     * */
    public static Boolean trueFalse(double x, double y) {
        if (x >= 0 && x <= 1) {
            if (y >= 0 && y <= 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method - 1.1.9 Write a code fragment that puts the binary representation of a positive integer N into a String s.
     * @param int number 
     * @return String - binary representation of a positive integer 
     * It uses StdIn.readInt() to get the command-line argument and assing it to the method. 
     * */
    public static String binaryRepresentation(int number) {
        String s = "";
        for (int n = number; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        return s;
    }

    /**
     * Method - 1.1.11 Write a code fragment that prints the contents of a two-dimensional boolean array, using * to represent 
     * true and a space to represent false. Include row and column numbers. 
     * @param Boolean[][] array - two-dimensional array 
     * @return void 
     * This method takes a two-dimensional boolean array as argument and prints in the console, returns void. 
     * It uses a two-dimensional array created in the client side of the program. 
     * */
    public static void printTwoDimensional(Boolean[][] array) {
        int lengthArr = array.length;
        for (int row = 0; row < lengthArr; row ++) {
            for (int column = 0; column < lengthArr; column++) {
                Boolean currentItem = array[row][column];
                StdOut.println("Row: " + row + " Column: " + column);
                if (currentItem) {
                    StdOut.println("*");
                } else {
                    StdOut.println(" ");
                }
            }
        }
    }

    /**
     * Method - 1.1.14 Write a static method lg() that takes an int value N as argument and returns 
     * the largest int not larger than the base-2 logarithm of N. Do not use Math. Recursive method.
     * @param int result - Stores the multiplication for each iteration as accumulator, and it is used to compare the base case with the actual result of the exponent.
     * @param int N - 2 ** x = N, it is used to define when to stop the recersive calls, base case, power. 
     * @param int exponent - Accumulates how many times the method has been iterated, it is the power of the exponent. 
     * @return int - log 2(result) = x - 1.
     * 
     * example client log(1000,1,0)
     * */
    public static int log(int N, int result,int exponent) { // option 1
        System.out.println("Result: " + result + " Exponent: " + exponent); // testing
        if (N <= 0) return exponent; 
        if (N <= result) return exponent - 1; 
        return log(N, result * 2, exponent + 1);    
    }

    public static int lg(int N) { // option 2
        int x = 0;
        for (int n = N; n > 1; n/= 2) x++;
        return x;
    }

    public static int lo(int N) { // option 3
        if (N <= 1) {
            return 0; // Base case: log2(1) = 0
        }

        int result = 0;
        int power = 2;

        while (power < N) { 
            power *= 2;
            result++;
        }

        return result;
    }

    /**
     * 1.1.15 Write a static method histogram() that takes an array a[] of int values and an integer M as arguments 
     * and returns an array of length M whose ith entry is the number of times the integer i appeared in the argument array. 
     * If the values in a[] are all between 0 and M−1, the sum of the values in the returned array should be equal to a.length.
     * @param arr an array a[] of int values 
     * @param M integer 
     * @return an array of lenghth M whose ith entry is the number of times the integer i appeared in the argument array
     */
    public static int[] histogram(int[] arr, int M) {
        int[] result = new int[M];
        for (int i = 0; i < arr.lenghth; i++) {
            result[a[i]] += 1;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {1,1,2,3,5,5,8};
        int[] b = histogram(a,9);
        StdOut.println()
    }
}