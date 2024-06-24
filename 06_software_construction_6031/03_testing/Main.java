public class Main {
    public static void main(String[] args) {
        boolean andAll(boolean[] bits) {
        boolean result = bits[0];
        for (int i = 1; i < 31; i++) {
            result = result && bits[i];
        }
        return result;
        }
    }
}