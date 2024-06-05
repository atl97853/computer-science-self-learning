#### **Iterating**
Syntax: 
```
int max = 0;
for (int x: list) {
    max = Math.max(x, max);
}
```
- You can iterate through arrays as well as lists. 
- The same code would work if the list were repaced by an array. 
- Math.max() is a function from the Java API, *Math* class. 
  
#### **Methods**
- In Java, statements generally have to be inside a method,
- and every method has to be in a class, 
- so the simplest way to write our hailstone program looks like this: Syntax:
```
public class Hailstone {
    /**
     * Compute a hailstone sequence.
     * @param n  starting number for sequence; assumes n > 0.
     * @return hailstone sequence starting with n and ending with 1.
     */
    public static List<Integer> hailstoneSequence(int n) {
        List<Integer> list = new ArrayList<Integer>();
        while (n != 1) {
            list.add(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        list.add(n);
        return list;
    }
}
```
- *public* means that any code, anywhere in the program cab refer to that class or method 
<br>(other access modifiers, like *private*, are used to gety more safety in a program, and to guarantee immutability for immutable types)
- *static* means that the method is a function that doesn't take a *self* parameter (in java is called *this*).
<br>(static method aren't called on an object, instead the right way to call a static method is using the class name instead of an object reference: Hailstone.hailstoneSequence(83), this is similar to the method call in Math.max(), Math is a class not an instance).
- The comment above the method is a specification of the method, specifications should be concise, clear and precise. The specification provides information that is not already clear from the method types. 
*<br>We’ll have a lot more to say about how to write good specifications in a few classes, but you’ll have to start reading them and using them right away.*

#### **Mutating values vs. reassigning variables**
