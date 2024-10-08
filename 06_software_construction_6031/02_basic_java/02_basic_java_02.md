## 02 Basic Java 2 - 2
### Objectives:
- Learn basic Java syntax and semantics 
- Transition from writing Python to writing Java 

Review: 
<br>**Safe from bugs:** *correct today and correct in the unknown future.*
<br>**Easy to understand:** *communicating clearly with future programmers including future you.*
<br>**Ready for change:** *designed to accommodate change without rewriting.*

<hr>

**Snapshot diagrams**
<br>Snapshot diagrams represent the internal state of a program at runtime, its stack/on the call stack(methods in progress an their local variables) ant its heap(objects that currently exist).

**Mutating values vs. reassigning variables**
<br>Mutating values:
- Mutation refers to directly modifying the value stored withing a variable.
- The variable itself cotinues to point to the same piece of memory, but the content of that memory location is changed. 

<br>Reassigning variables: 
- Reassignment involves creating a new association between a variable name and a value. 
- Pointing the variable to a different piece of memory holding a new value. 
```
int x = 10; // x points to a box with value 10 (primitive)

// Mutation (changing the value in the same box)
x = 20;  // Now x points to the same box, but the value is 20

String name = "Alice";  // name points to a box with the String "Alice" (object)

// Reassignment (pointing name to a different box with a new value)
name = "Bob";  // Now name points to a completely different box with the String "Bob"
```
**call-by-value**
```
void f(String s, StringBuilder sb) {
  s.concat("b"); 
  // because the fresh string that the .concat() method is assign it to nothing, that's why the value of s doesn't change at all.
  s += "c";
  sb.append("d");
}
String t = "a";
StringBuilder tb = new StringBuilder(t);
f(t, tb);
```
<br>This kind of parameter-passing behavior is referred to as call-by-value, because the parameter receives an initial value from the caller, but then the parameter can be freely reassigned without affecting the caller.

**== vs. esquals**
<br>`x and y -> String "abc" | z -> String "abc"`
<br>Example:
- x.equals(y): returns true because x and y have the same characters
- x == y: returns true because x and y point to the same object
- x.equals(z): returns true because x and z have the same characters
- x == z: returns false because x and z point to different objects

<br>As a general rule:
- Use == for comparing primitive values, like ints, chars, and doubles.
- Use equals() for comparing object values, like lists, arrays, strings, and other objects.
- Using equals() on primitive types is fortunately easy to catch. 5.equals(5) produces a static error because Java doesn’t allow calling any method on a primitive type.

**Java Collections**
<br>A list contains an ordered collection of zero or more objects, where the same object might appear multiple times. We can add and remove items to and from the List, which will grow and shrink to accomodate its contents.

<-> *add all the methods later* <->

**Generics: declaring List, Set, and Map variables**
- *A generic type is an object-oriented type (class or interface) that accepts one or more type parameters, allowing the class to defer the specification of such parameters until the class is declared and instantiated by a client (user) of the class.*

<br>In Java we can restrict the type of objects contained in the collection. When we add an item, the compiler can perform static checking to ensure we only add items of the appropriate type. Then, when we pull out an item, we are guaranteed that its type will be what we expect.
<br>Here's the syntax for declaring some variables to hold collections:
```
List<String> cities;        // a List of Strings
Set<Integer> numbers;       // a Set of Integers
Map<String,Turtle> turtles; // a Map with String keys and Turtle values
```
- Because of the way generics work, we cannot create a collection of primitives types. 
-  For example, Set<int> does not work. However, ints have an Integer wrapper we can use (e.g. `Set<Integer> numbers`).
-  In order to make it easier to use collections of these wrapper types, Java does some automatic conversion. If we have declared `List<Integer> sequence`, this code works:
```
// wrap 5 as an Integer object, and append it to the sequence
sequence.add(5);              
 // get the second Integer element, and unwrap it into an int
int second = sequence.get(1);
```

**ArrayLists and LinkedLists: creating Lists**
- Specification of the type: what does it do? 
- Implementation: what is the code? 
  
<br>List, Set, and Map are all interfaces: 
- They define how these respective types work,
- but they don't provide implementation code. 
- One potential advantange of this is that we, the users of these types, get to choose different implementations in different situations.

<br>Here's how to create some actual Lists: 
<br>`List<String> firstNames = new ArrayList<String>();`
<br>`List<String> lastNames = new LinkedList<String>();`
<br>If the *generic type parameters* are the same on the left and right, Java can infer what's going on and save us some typing: (just a reminder, Generics means parameterized types)
<br>`List<String> firstNames = new ArrayList<>();`
<br>`List<String> lastNames = new LinkedList<String>();`
- We can create an array of primitive types, but not a List, we need to use the *Integer* wrapper. 
- ArrayList and LinkedList are two *implementations* of List.
- Both provide all the operations of *List*.
- Both will behave the same way. 
- If we swapped which one used ArrayList vs. LinkedList, our code will not break. 
- The only difference is performance: 
  - They differ in their underlying implementation and performance characteristics. 
  ```
  Feature	               ArrayList	  LinkedList
  Data Structure	         Array	    Doubly Linked List
  Add/Remove(Middle)	     O(n)	        O(1)
  Add/Remove(Start/End)	   O(1)	        O(1)
  Random Access	           O(1)	        O(n)
  Memory Usage	           Lower	    Higher
  ```
<br>In summary:
- ArrayList is a good choice for general-purpose lists where you need a balance between access speed and modification operations. 
- LinkedList is ideal for scenarios where frequent insertions/removals are essential even if sacrificing some random access speed and memory efficiency.
- When in doubt, use ArrayList.

<br>Initialize an ArrayList or LinkedList in one go: 
```
List<String> firstNames = new ArrayList<>(List.of("Huey", "Dewey", "Louie"));
List<String> lastNames = new ArrayList<>(Set.of("Duck));
```
- `List.of()` produces an immutable list, `new ArrayList<>(List.of())` produces a mutable list, if you need a mutable list, this is simpler than making mutiple calls to `add()`.

**HashSets and HashMaps: creating Set and Maps**
- HashSet default choice for Set: `Set<Integer> numbers = new Hashset<>();`
- HashMap default choice for Map: `Map<String, Turtle> turtles = new HashMap<>();`

**Iteration:**
<br>list / hashset iteration: 
```
for (datatype variable: list/set) {
  content 
}
```
*java automatically converts between int and Integer, using the simpler primitive int type is preferable to the Integer object wrapper wherever possible, it's less error-pone, as discussed in *== vs. equals*.*

Map iteration: (iterate over the keys) 
```
for (String key : turtles.keySet()) {
  System.out.println(key + ": " + turtles.get(key));
}
```
*under the hood this kind of for loop uses an *Iterator*, a design pattern we'll see later in the class, also be careful trying to mutate a collection while your're interating over it, next lectures...*

**Enumerations**
<br>When the set of values is small and finite, it makes sense to define all the values as named constants, which java calls an *enumaration* and expresses with the *enum* construct.
```
public enum Month { 
    JANUARY, FEBRUARY, MARCH, APRIL, 
    MAY, JUNE, JULY, AUGUST, 
    SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}

public enum PenColor { 
    BLACK, GRAY, RED, PINK, ORANGE, 
    YELLOW, GREEN, CYAN, BLUE, MAGENTA;
}
```
*enums are like special classes that define a set of named constants, they shouldn't be placed within methods, they need to be declared outside of  the method main*

```
public class Main {
    public enum Month { 
        JANUARY, FEBRUARY, MARCH, APRIL, 
        MAY, JUNE, JULY, AUGUST, 
        SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    }
    static public void main(String[] args) {
        Month month; // initialize variable
        month = Month.MARCH; // declare 
        Month nov = Month.NOVEMBER; // initialize and declare 
        System.out.println(nov);
    }
}
``` 
*enumeration is more typesafe, because it can catch mistakes like type mismatches or misspellings*

**Java API documentation**
<br>The java API is a large set of generally useful tools for programming pretty much anything. 
<br>Some examples: 
- java.lang.String is the full name for String. We can create objects of type String just by using "double quotes".
- java.lang.Integer and the other primitive wrapper classes. Java automagically converts between primitive and wrapped (or “boxed”) types in most situations.
- java.util.List is like a Python list, but in Python, lists are part of the language. In Java, Lists are implemented in… Java!
- java.util.Map is like a Python dictionary.
- java.io.File represents a file on disk. Take a look at the methods provided by File: we can test whether the file is readable, delete the file, see when it was last modified…
- java.io.FileReader lets us read text files.
- java.io.BufferedReader lets us read in text efficiently, and it also provides a very useful feature: reading an entire line at a time.

<br>https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/io/BufferedReader.html
<br>*This is the first place you should go to understand a class or what a method does.*
- **At the top right corner is the search box. You can use it to jump to a class or interface, or straight to a particular method.**

**Specifications**
<br>These detailed descriptions are specifications
<br>They allow us to use tools like *String*, *Map*, or *BufferedReader*
<br>without having to read or understand the code that implements them 
  - ***reading, writing, understanding, and analyzing specifications will be one of our first major undertakings in 6.031***
  
<br>https://docs.oracle.com/en/java/javase/15/docs/api/