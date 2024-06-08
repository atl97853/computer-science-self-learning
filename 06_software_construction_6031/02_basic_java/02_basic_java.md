## 02 Basic Java 
### Objectives:
- Learn basic Java syntax and semantics 
- Transition from writing Python to writing Java 

Review: 
<br>**Safe from bugs:** *correct today and correct in the unknown future.*
<br>**Easy to understand:** *communicating clearly with future programmers including future you.*
<br>**Ready for change:** *designed to accommodate change without rewriting.*

#### **From Python to Java**

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
- Generic collections requiere one or more type parameters for the element types as well: 
```
new <class name><element types>(<arguments>)
List<String> names = new ArrayList<String>();
```

**Interfaces**
- It specifies the set of methods that an implementing class must include. 
- A single class can implement several different interfaces. 
- An interface guarantees a common, abstract behavior of all implementing classes:
  - The `java.util.List` interface specifies methods for all classes of lists, including `java.util.ArrayList` and `java.util.LinkedList`.
- An interface can extend another, more general interface:
  - The *List interface* extends the *Collection interface*. 
  - This means that all of the methods required by the *Collection interface* will also be required for all lists. 
- Interfaces are like interstitial glue that holds program components together. 
  
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