/**
 * binary search and tests it for an application 
 * known as whitelist filtering. 
 */


import java.util.Arrays;

public class BinarySearch {
    public static int indexOf(int[] a, int key) {
        int lo = 0; 
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(mid); // testing mid value
            if (key < a[mid]) hi = mid -1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }    

    public static void main(String[] args){ // unit test client
        int[] whitelist = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println("This is the index of your value " + index(whitelist, 3));
    }
}
