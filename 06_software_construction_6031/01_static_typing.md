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
Change is a necessary evil. But good programmers try to avoid things that change, because  they may change unexpectedly. 
<br>**Immutability**:
- Intentionally forbidding certain things from changing at runtime.
<br>*(will be a major design principle in this course).*
- An inmmutable type is a type whose values can never change once they have been created. 
- In java we can make a reference unreassignable, declare it with the keyword *final*:
<br>`final int n = 5;`
- If the Java compiler isn't convinced that your *final variable* will only be assigned once at runtime, then it will produce a compiler error. 
- So *final* gives you static checking for unreassignable references. 
- It's good practice to use *final* for declaring the *parameters of a method* and as many *local variables* as possible. 

Exercise: 
```
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
```
Which variables can we declare final, because they are never reassigned in the code?

Answer:
<br>n is reassigned many times in the code, so we can't declare it final. 
<br>But list is only assigned once, to new ArrayList<Integer>(). 
<br>Subsequently, even though we call .add() on the list to add newly-discovered elements of the hailstone sequence,
<br>we never reassign the list variable to refer to a different list. 

#### **Documenting assumptions**
Why do we need to write down our assumptions? Because programming is full of them, and if we don't write them down, we won't remember them, and other people who need to read or change our programs later won't know them. 
<br>Programs have to be written with two goals in mind: 
- communicating with the computer. First persuading the compiler that your program is sensible, syntactically correct and type-correct. Then getting the logic right so that it gives the right results at runtime. 
- communicating with other people. Making the program easy to understand, so that when somebody has to fix it, improve it, or adapt it in the future, they can do so. 

Examples: 
- Writing the type of a variable down, documents an assumption about it. 
- Declaring a variable final is also a form of documentation. 
- We should document another assumptions that java doesn't check automatically, for example: that *n* must be positive (as we document in the comment above the code).

#### **Hacking vs. engineering**
Hacking is often marked by unbridled optimism: 
- Bad: writing lost of code before testing any of it. 
- Bad: keeping all the details in your head, assuming you'll remember them forever, instead of writing them down in your code. 
- Bad: assuming that bugs will be nonexistent or else easy to find and fix.
