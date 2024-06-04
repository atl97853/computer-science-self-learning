**Iterating**
Syntax: 

int max = 0;
for (int x: list) {
    max = Math.max(x, max);
}

- You can iterate through arrays as well as lists. 
- The same code would work if the list were repaced by an array. 
- Math.max() is a function from the Java API, *Math* class. 
  
**Methods**
- In Java, statements generally have to be inside a method,
- and every method has to be in a class, 
- so the simplest way to write our hailstone program looks like this: Syntax:

public class Hailstone {
    public static List<Integer> hailstoneSequence(int n) {
        List<Integer> list = new ArrayList<Integer>();
        while (n != 1) {
            list.add(n); *it assumes n > 0?*
            if (n % 2 == 0) {
                n = n /2;
            } else {
                n = 3 * n + 1;
            }
        }
        list.add(n);
        return list;
    }
}