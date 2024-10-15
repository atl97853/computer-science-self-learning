public class WordUtils {
    /** Exercise 4.1.1. Try writing this method by yourself.
     * The method should take in an SLList of strings and
     * return the longest string in the list.*/
    public static String longest(SLList<String> list) {
        String longest = "";
        for (String word: strL) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return  longest;
    }

    public static String longest(AList<String> list) {
        String longest = "";
        for (String word: strL) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return  longest;
    }

    public static void main(String[] args) {
        // String[] myL = {"123", "1234", "12"};
        // System.out.println(longest(myL));
    }
}
