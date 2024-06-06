// public class Something {
//     public static void main(String[] args) {
//         int[] a = new int[10];
//         int i = 0;
//         int n = 300;
//         while (n != 1) {
//             a[i] = n;
//             i++;
//             if (n % 2 == 0) {
//                 n = n /2;
//             } else {
//                 n = 3 * n + 1;
//             }
//             System.out.println(n);
//         }
//         a[i] = n;
//         i++;
//     }
// }

// the program will pass the compile check, 
// but it will crash at runtime, so the error is detected at runtime
// dynamic check because it's about values, not data types. 



// List<Integer> list = new ArrayList<Integer>();
// int n = 3;
// int index = 0;
// while (n != 1) {
//     myList.set(index, n);
//     index++;
//     if (n % 2 == 0) {
//         n = n /2;
//     } else {
//         n = 3 * n + 1;
//     }
//     System.out.println(n);
// }

public class static_typing {

  public static void main(String[] args) {
    System.out.println("Hello, World!");
  }
}
