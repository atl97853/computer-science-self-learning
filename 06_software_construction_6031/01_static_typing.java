public class Something {
    public static void main(String[] args) {
        int[] a = new int[100];
        int i = 0;
        int n = 3;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n /2;
            } else {
                n = 3 * n + 1;
            }
        }
        a[i] = n;
        i++;
        System.out.println(a[100]);
    }
}