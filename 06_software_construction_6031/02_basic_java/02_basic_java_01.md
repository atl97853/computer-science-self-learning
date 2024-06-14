## 02 Basic Java 1 - 2
### Objectives:
- Learn basic Java syntax and semantics 
- Transition from writing Python to writing Java 

Review: 
<br>**Safe from bugs:** *correct today and correct in the unknown future.*
<br>**Easy to understand:** *communicating clearly with future programmers including future you.*
<br>**Ready for change:** *designed to accommodate change without rewriting.*
<hr>

#### **From Python to Java**
https://kennethalambert.com/pythontojava/

- Python and Java programs both compile to machine-independent byte code, which can then be run *on virtual machines (PVM and JVM)* on host computers. 
- Type checking in Java is done at compile time and in Python at run time. 
- Python code can also be tried out interactively within an interpreter, whereas Java programs must flow through an **edit/compile/execute cycle.**

**Programs and Their Execution (in Java)**
- Programs consist of interfaces and classes. 
- Interfaces and classes are contained in source files ( .java extension).
- Source file compiles into one or more executable byte code files ( .class extension).
- Classes and interfaces can be part of a package. 
- The byte code files for a package are usually contained in a directory whose name is the package name. 
- *Programs must first be compiled before they can be executed.*
- Java programs are executed in a interpreter called JVM (Java Virtual Machine).
- Applets are programs that run in a Web browser. 
- Applications are programs that run on a standalone computer.
  
**Running a Program**
<br>A java application must first be compiled: `javac HelloWorld.java`.
<br>The byte code file can then be run: `java HelloWorld` (the file has .class extension).
*<br>Syntax and type errors are caught at compile time. All other error are caught at run time.*

**First Program**
```
public class HelloWorld {
    static public void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```
- source file converted into a byte code file
- byte code loaded into the JVM
- JVM calls main method, which is a class method in HelloWorld
- *a java application must include at least one class that define a main method*

**Syntatical Structure**
- Blocks of code in statements and definitions are enclosed in curly braces ( {  } ).
- Simple statements end with a semicolon ( ; ).

**Categories of Data Types**
- Primitive types, numeric types and boolean, the values of primitive types are immutable and are not instances of classes. 
  - Java doesn’t allow calling any method on a primitive type.
- Reference types are classes, thus, any object or instance of a class is of a reference type.

**Type Conversion**
- *Cast operator*, it's formed by enclosing the destination type name in parentheses: 
```
(int) 3.14
(double) 3
(char) 45
(int) 'a'
```

**Comparions and Comparables**
- All values of primitive types are comparable.
- Values of reference types are comparable if and only if they recognize the compareTo method.

**Method Calls**
- All methods are defined to return a specific type of value. 
- When the return value is not expected, the method's return type is *void*.
- *Otherwise, the type of value returned must be compatible at compile time with the type of value expected.*

**Import Statements**
<br>A package resource is imported using the form: 
`import <package name>.<resource name>;`
<br>The resource is then referenced wihout the package name as a qualifier:
```
import javax.swing.JButton;
JButton b = new JButton("Reset");
```
<br>Alternatively, all of the package's resources can be imported using the form: 
`import <package name>.*;`

**Terminal Output**
- The method *println*, when run with the class variable *System.out*, converts data to text, displays it, and moves the cursor to the next line:
`System.out.println("Hello World!");`
- To prevent the output of a newline, use the method *print*:
`System.out.print("Hello World!");`

**Terminal Input**
- The *Scanner* class is used for the input of text and numeric data from the keyboard. 
- You need to instantiate a *Scanner* and use the appropriate methods for each type of data being input. 
- Create a Scanner object attached to the keyboard: 
`Scanner keyboard = new Scanner(System.in);`
  - Input a line of text as a string: 
`String s = keyboard.nextLine("Enter your name: ");`
  - Input an integer: 
`int i keyboard.nextInt("Enter your age: ");`
  - Input a double: 
`double d = keyboard.nextDouble("Enter your wage: ");` 
<br>*Caution: using the same scanner to input strings after numbers can result in logic error, it's best to use separate scanner objects for numbers and text.*

**For Loops**
- There are two types: 
  - a loop  for visiting each element in an iterable object, and 
  - a loop with the same behavior as a while loop
  
- Form of the first type, also called *enhanced for loop*:
```
for <type> <variable> : <iterable> {
    <statement>
}
for (String s : aListOfStrings) {
    System.out.println(s);
}
```
- Form of the second type: 
```
for (<initializer>; <continuation>; <update>) {
    <statement>
}
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```
- The loop above has the same behavior as the following while loop:
```
int i = 1;
while (i <= 10) {
    System.out.println(i);
}
```

**Object Instantiation**
- The form for object instantiation is like this: 
```
new <class name>(<arguments>)
CheckingAccount account = new CheckingAccount("etc...")
```
- ***Generic collections requiere one or more type parameters for the element types as well:***
```
new <class name><element types>(<arguments>)
List<String> names = new ArrayList<String>();
```

**Interfaces**
- It specifies the set of methods that an implementing class must include. 
- A single class can implement several different interfaces (sets of methods). 
- An interface guarantees a common, abstract behavior of all implementing classes:
  - The `java.util.List` interface specifies methods for all classes of lists, including `java.util.ArrayList` and `java.util.LinkedList`.
- An interface can extend another, more general interface:
  - The *List interface* extends the *Collection interface*. 
  - This means that all of the methods required by the *Collection interface* will also be required for all lists. 
- Interfaces are like interstitial glue that holds program components together.
- List, Set, and Map are all interfaces: they define how these respective types work, but they don’t provide implementation code. There are several advantages, but one potential advantage is that we, the users of these types, get to choose different implementations in different situations. *(go to 02_basic_java_02 - ArrayLists and LinkedLists)*
  
<br>Uses of interfaces: 
```
List<String> aList = new ArrayList<String>();
aList.add("Ragnar");
Collections.sort(aList);
```
- *The ArrayList class implements the List interface*.
- The method *Collections.sort()* expects a *Collection of Comparables*  as an argument. 
- Because the *String* class implements the *Comparable interface*  and the *List interface* extends the *Collection interface*, the compiler does not complain and all goes well. 
  - The code leveragues Java's type system and interface implementations. 
  - It's not pure duck typing because the compiler performs static checks, but it exhibits some duck-like behavior due to the flexibility within the type system. 
  - The array meets the criteria to be able to use the Collections.sort() method, and that is called apparently autoboxing. 
  - Autoboxing it's the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes.

**Summary**
<br>Think of an interface as a contract for a service provider (class). The contract specifies the services (methods) the provider must offer, but it doesn't detail how those services will be performed. The class acts as the service provider itself, implementing the methods in the contract (interface) according to its own logic.

<br>Interfaces are designed for *multiple inheritance* in Java. A class can implement methods from multiple interfaces, inheriting the functionalities defined in each. 
<br>This promotes code reusability and allows you to combine functionalities from different interfaces into a single class. 
  - Interfaces: Multiple inheritance from multiple interfaces.
  - Classes: Single inheritance from one superclass, but can implement multiple interfaces
  
<br>An interface is like a class that has variables and methods, however, unlike a class, the methods in an interface are abstract by default.
<br> Multiple inheritance through interface occurs in Java when a class implements multiple interfaces or when an interface extends multiple interfaces.
<br>***Interface = set of methods.***
<hr>

**Collections**
- **Strings, Arrays, Lists, Sets, Dictionaries or Maps, Iterators.**
  - Mutable: Arrays, Lits, Sets, Maps
  - Immutable: Strings

**Arrays**
- An array is a sequence of elements of the same type. 
- Each element is accessed in constant time using an index position ( *O(1)* ).
- Unlike a list, an array's length is fixed when it is created and cannot be changed.
  
**Sets**
<br>A generic set specifies the element type of the set variable and the instantiated set object, as follows:
```
Set<String> names = new HashSet<String>();
SortedSet<Integer> ints = new TreeSet<Integer>();
```
<br>A set can also be created from a list, as folllows: 
<br>`Set<String> names = new HashSet<String>(listOfNames);`

<br>*Java collections typically include a constructor that accepts another collection as an argument and adds its elements to the newly instantiated collection.*

**Dictionaries or Maps**
- A map is a mutable collection of 0 or more unique key/value pairs. 
- A generic map constrains its keys to the same *supertype* and values to the same *supertype*.
- The *Map* interface includes the methods common to all implementing classes. 
  - The *SortedMap* interface extends the *Map* interface to include methods for sorted maps.
- The implementing classes, include *HashMap* and *TreeMap*.
  - *Treemap* can return its keys in sorted order. Thus, it also implements the SortedMap interface. 
- A generic map specifies the key/value types of the map variable and the instantiated map object, as follows: 
```
Map<String, Integer> names = new HashMap<String, Integer>();
SortedMap<Integer, Integer> ints = new TreeMap<Integer, Integer>();
```
```
// Associate 10 random ages between 1 and 10 with consecutive names:
for (int i = 1; i <= 10; i++) {
  string name = "Name" + i;
  names.put(name, (int)(Math.random() * 10 + 1));
}
// Print all keys and their values: 
for (String key : names.keySet()) {
  System.out.println(key + "" "" + names.get(key));
}
```

**Iterators**
- An iterator is an object that supports the traversal fo a collection. 
- All collections implement the *Iterable interface*. This interface includes a single method, *iterator()*, which returns an iterator object.
- An iterator object implements the *Iterator interface*. This interface includes the methods: *next(), hasNext(), and remove()*.
- Like collections, iterator can be generic. Thus, the generic collection's element type must be specified when a variable of type *Iterator* is declared. 
```
// Create a list of strings: 
List<String> lyst = new ArrayList<String>();
// Open an iterator on lyst: 
Iterator<String> i = lyst.iterator();
// Print all the strings in lyst using the iterator: 
While (i.hasNext()) {
  String s = i.next();
  System.out.println(s);
}
```
<hr>

**Defining Classes**
- Class Structure
- Visibility Modifiers
- Instance Variables and Constructors
- Defining Other Constructors
- Instance Methods
- Method Overloading
- Class (static) Variables and Methods
- Symbolic Constants (Final Variables)
- Defining a String Representation
- Defining Equality
- Defining Comparisons
- Defining Interfaces
- Inner Classes
- Defining an Iterator

**Class Structure**
<br>Class definitions have the general form: 
```
<visibility modifier> class <name> extends <superclass name> 
  implements <list of names>
<class variables>
<class methods>
<instance variables>
<instance methods>
<inner classes>
```
- *Classes that do not explicitly extend another class, extend the Object class by default*.
- A class may implement zero or more interfaces.
<br>Example: 
```
public class Student {
  
  public static final int NUM_GRADES = 5

  private String name;
  private int[] grades;

  public Student(String name) {
    this.name = name;
    this.grades = new int[NUM_GRADES];
  }

  public String getName() {
    return this.name;
  }

  public int getGrade(int i) {
    return this.grades[i - 1];
  }

  public void setGrade(int i, int newGrade) {
    this.grades[i - 1] = newGrade;
  }

  public String toString() {
    /*
        Format: Name on the first line
        and all grades on the second line,
        separated by spaces.
        */
        String result = this.name + '\n';
        for (String grade : this.grades)
            result += grade + ' ';
        return result;
  }
}
```
Usage:
```
Student s = new Student("Mary);
for (int i = 1; i <= Student.NUM_GRADES; i++) {
  s.setGrades(i, 100);
}
System.out.println(s);
```

**Instance Variables and Constructors**
<br>Instance variables: 
- Instance variables are declared at the same level as methods within a class definition. 
- They are usually given private access to restrict visibility. 
- They can receive initial values either when they are declared or in a constructor. 
- Instances variable references may or may not be prefixed with the reserved word *this*.

<br>In the following example, the variables *this.name* and *this.grades* are instance variables, whereas the variables *NUM_GRADES* is a class variable:
```
public class Student {
  public static final int NUM_GRADES = 5;
  private String name;
  private int[] grades;

  public Student(String name) {
    this.name = name;
    this.grades = new int[NUM_GRADES];
  }
}
```
- *the static keyword means: since it's static, NUM_GRADES is stored in the class's memory area, not within individual object instances, this memory area is shared by all objects of the class.*
- *the constructor method is named Student, in java a constructor's name always matches the class name*.
<br>The JVM automatically calls the constructor when the programmer requests a new instance of the class. 
<br>`Student s = new Student("Atl");`
<br>The constructor may receive one or more arguments to supply initial values for the object's data.

**Defining other Constructors**
<br>Method *overloading* allows more than one constructor to be defined, as long as they have different numbers and/or types of arguments. 
```
public class Student {
  public static final int NUM_GRADES = 5;
  private String name;
  private int[] grades;
  
  public Student (String name) { // first constructor
    this.name = name;
    etc ... 
  }
  public Student() { // this is the other constructor
    this("");
  }
}
```
<br>The Student class is given a default constructor that expects no arguments.
<br>The new constructor calls other constructor by using the keyword *this* and the appropriate argument.

**Defining Instance Methods**
<br>The form of an instance method definition is: 
<br>`<visibility modifier> <return type> <name> <args>{<statements>}`
<br>All methods must specify a return type.
<br>All type checking is done at compile time. 
```
public class Student {
  // instance methods 
  public String getName() {
    return this.name;
  }
  public int getGrade(int i) {
    return this.grades[i - 1];
  }
}
```

**Method Overloading**
<br>Two methods are overloaded if they have the same name but different signatures.
<br>For example, a Student class might have three methods named resetGrades for resetting all the grades, and all are distinct methods:
- First method, expects no arguments:
```
public void resetGrades(){
  resetGrades(0);
}
```
- Second method, expects a single integer argument
```
public void resetGrades(int grade){
  for (int i = 0; i < student.NUM_GRADES; i++) {
    this.grades[i] = grade;
  }
}
```
- Third method, expects an array of integers: 
```
public void resetGrades(int[] grades){
  for (int i = 0; i < Student.NUM_GRADES; i++) {
    this.grades[i] = grades[i];
  }
}
```
Usage: 
```
Student s = new Student();
s.resetGrades(100);
s.resetGrades();
int[] newGrades = {85, 66, 90, 100, 73};
s.resetGrades(newGrades);****
```

**Class (static) Variables and Methods**
- Class variables name data that are shared by all instances of a class. 
- A class variable declaration is qualified by the reserved word *static*. 
  - the static keyword means: since it's static, NUM_GRADES is stored in the class's memory area, not within individual object instances, this memory area is shared by all objects of the class.
- Outside of the class definition, class variable references are prefixed with the name of the class. 
- Class variables are spelled in uppercase by convention.
<br>Example: 
```
public class Student {
  public static final int NUM_GRADES = 5;
}
System.out.println(Student.NUM_GRADES);
```

- Class methods are methods that know nothing about instances of a class 
- but can access class variables an call other class methods for various purposes. 
- A class method header is qualified by the reserved word *static*. 
- Class method calls are prefixed with the name of the class. 
<br>Example: 
```
public class Student {
  // instance method definitions and variable declarations. 
  public static char getLetterGrade(int grade) {
    etc
  }
}
s = new Student();
System.out.println(Student.getLetterGrade(s.grade)) 
```

**Defining Interfaces**
<br>The form of an interface is:
```
public interface <name> extends <name> {
  <final variables>
  <method headers>
}
```
- The extension of another interface is optional.
<br>Example: *the code for this interface would be placed in its own source file, this file can be compiled before any implementing classes are defined.*
```
public interface TrueStack<E> extends Iterable<E>{
  public boolean isEmpty();
  public E peek();
  public E pop();
}
```
<br>Each implementing class would in turn be placed in its own file, an interface must be succesfully compiled before any of its implementing classes. 
```
import java.util.*;
// class implementing an interface
public class ArrayStack<E> implements TrueStack<E>{ 
  private List<E> list;
  public ArrayStack(){
    list = new ArrayList<E>();
  }
  public boolean empty(){
    return list.isEmpty();
  }
  public E peek(){
    return list.get(list.size() - 1);
  }
  public E pop(){
    return list.remove(list.size() - 1);
  }
}
```

**Inner Classes**
<br>A class might be defined just for use in another class definition. This is know as inner classes, nested classes, and are specified as private classes. 
<br>Example: 
```
public class LinkedStack<E> implements TrueStack<E>{
  private class OneWayNode<E> {
    private E data;
    private OneWayNode next;
    private OneWayNode(E data, OneWayNode next);{
      this.data = data;
      this.next = next;
    }
  }
}
```
<hr>

**Inheritance**
- Defining Subclasses 
- Abstract Classes and Methods

**Defining Subclasses**
<br>The form for defining a subclass is:
```
public class <subclass name> extends <parent class name>{
  <variables and methods>
}
```

**Abstract Classes and Methods**
- When two or more classes contain redundant code, it can be factored into a common parent class.
- This class is typically called an abstract class because it is not instantiated.
- It has de reserved word *abstract*, it is used for abstract classes and methods.


