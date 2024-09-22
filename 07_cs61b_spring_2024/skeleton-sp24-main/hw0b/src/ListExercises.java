import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        if (L.isEmpty()) return 0;
        for (int elem : L) {
            sum += elem;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> lst = new ArrayList<>();
        for (int elem : L) {
            if (elem % 2 == 0 ) lst.add(elem);
        }
        return lst;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> lst = new ArrayList<>();
        for (int elem1: L1) {
            for (int elem2 : L2) {
                if (elem1 == elem2) {
                    lst.add(elem1);
                }
            }
        }
        return lst;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int occ = 0;
        for (String w : words ) {
            for (char l : w.toCharArray()) {
                if (l == c) occ++;
            }
        }
        return occ;
    }
}
