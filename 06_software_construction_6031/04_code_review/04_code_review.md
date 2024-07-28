# Reading 4: Code Review 

In today's class, we will practice: 
- **code review:** reading and discussing code written by somebody else 
- **general principles of good coding:** things you can look for in every code review, regardless of programming language or program purpose

## Code review 
Code review is careful, systematic study of source code by people who are not the original author of the code.

Code review really has two purposes: 
- **Improving the code.** Finding bugs, anticipating possible bugs, checking the clarity of the code, and checking for consistency with the project's style standards. 
- **Improving the programmer.** Code review is an important way that programmers learn and teach each other, about new language features, changes in the design of the project or its coding standards, and new techniques. In open source projects, particularly, much conversation happens in the context of code reviews.

Code review is widely practiced in **open source projects** like **Apache** and **Mozilla**. Code review is also widely practiced in industry. 
<a href="https://google.github.io/eng-practices/review/">Google's code review process</a>

### Style standards
It’s important to be self-consistent, however, and **it’s very important to follow the conventions of the project you’re working on.** Be a team player.

The rest of this reading talks about some of these rules, at least the ones that are relevant at this point in the course, where we're mostly talking about writing basic Java. **These are some things you should start to look for when you're code reviewing other people's code, and when you're looking at your own code for improvement.**

## Smelly example #1
Programmers often describe bad code as having a “bad smell” that needs to be removed. “Code hygiene” is another word for this. Let’s start with some smelly code.


```
public static int dayOfYear(int month, int dayOfMonth, int year) {
    if (month == 2) {
        dayOfMonth += 31;
    } else if (month == 3) {
        dayOfMonth += 59;
    } else if (month == 4) {
        dayOfMonth += 90;
    } else if (month == 5) {
        dayOfMonth += 31 + 28 + 31 + 30;
    } else if (month == 6) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31;
    } else if (month == 7) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30;
    } else if (month == 8) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31;
    } else if (month == 9) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
    } else if (month == 10) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
    } else if (month == 11) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
    } else if (month == 12) {
        dayOfMonth += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 31;
    }
    return dayOfMonth;
}
```
## Don't repeat yourself (DRY)
***Duplicated code is a risk to safety. If you have identical or very similar code in two places, then the fundamental risk is that there's a bug in both copies, and some maintainer fixes the bug in one place but not the other.***
- Avoid duplication, the longer the block you're copying, the riskier it is. 
- Avoid identical code. 

***Don't Repeat Yourself, or DRY for short, has become a programmer's mantra.***

One reason why repeated code is bad is because **a problem in the repeated code has to be fixed in many places, not just one.**

## Commets where needed 
***Good comments should make the code easier to understand, safer from bugs (because important assumptions have been documented), and readier for change.***

One kind of crucial comment is a **specification**, which appears above a method or above a class and **documents the behavior of the method or class.**
- Specifications document assumptions.
- In Java, this is conventionally written as a Javadoc comment
```
/**
 * Compute the hailstone sequence.
 * See http://en.wikipedia.org/wiki/Collatz_conjecture#Statement_of_the_problem
 * @param n starting number of sequence; requires n > 0.
 * @return the hailstone sequence starting at n and ending with 1.
 *         For example, hailstone(3)=[3,10,5,16,8,4,2,1].
 */
public static List<Integer> hailstoneSequence(int n) {
    ...
}
```
**Obscure code should get a comment:** Obscure code refers to code that is difficult for humans to understand. 

```
int sum = n*(n+1)/2;  // Gauss's formula for the sum of 1...n

// here we're using the sin x ~= x approximation, which works for very small x
double moonDiameterInMeters = moonDistanceInMeters * apparentAngleInRadians;
```

## Fail fast 
***Failing fast means that code should reveal its bugs as early as possible. The earlier a problem is observed (the closer to its cause), the easier it is to find and fix.***

static checking fails faster than dynamic checking, and dynamic checking fails faster than producing a wrong answer that may corrupt subsequent computation.
- static checking > dynamic checking > no checking at all. 

**When you find a bug, complain about it immediately.** 
- **throwing an exception**
- **defensive programming practice:** aim to make software more robust and resilient to errors. It's basically a way to write code that anticipates and handles problems before they crash the program or cause unexpected behavior.

## Avoid magic numbers 
There’s a computer science joke that the only numbers that computer scientists understand are 0, 1, and sometimes 2.

***One way to explain a number is with a comment, but a far better way is to declare the number as a named constant with a good, clear name.***

dayOfYear is full of magic numbers, which illustrate some of the reasons they should be avoided:

- **A number is less readable than a name.** In dayOfYear, the month values 2, …, 12 would be far more readable as FEBRUARY, …, DECEMBER.
- **Constants may need to change in the future.** Using a named constant, instead of repeating the literal number in various places, is more ready for change.
- **Constants may be dependent on other constants.** In dayOfYear, the mysterious numbers 59 and 90 are particularly pernicious examples. 
  - ***Not only are they uncommented and undocumented, they are actually the result of a computation done by hand by the programmer – summing the lengths of certain months.*** 
  - ***This is less easy to understand, less ready for change, and definitely less safe from bugs.*** 
- ***Don’t hardcode numbers that you’ve computed by hand.*** Use a named constant that visibly computes the relationship in terms of other named constants.

A named constant is more ready for change. 

If you have a profusion of magic numbers in your code, it can be a sign that you need to take a step back and treat those numbers *as data* rather than named constants, and put them into a data structure that allows for simpler code. 

**When 0 is used as an integer value** – as the lowest value in counting, for example, or as the identity value in addition – **it is not a magic number**, because these uses are its primary meaning.

**But when it is used symbolically** – here, to represent a month, or a sorting algorithm – **then it becomes magical**, and a named constant would be better.

***Using numbers with a cryptic meaning/usage can be considered magic numbers.*** 

(the type of the constant doesn’t particularly matter to the notion of a magic number. Character and string constants can be magical too, for the same reasons that numeric constants are magical: when their origin is obscure, or when their purpose in the computation is obscure, or when they have hidden dependencies on other constants. ->)

**Example 1:**
<br>Consider this code, which is intended to draw a regular pentagon:
```
for (int i = 0; i < 5; ++i) {
    turtle.forward(36);
    turtle.turn(72);
}
```
The magic numbers in this code cause it to fail all three of our measures of code quality: it’s not safe from bugs (SFB), not easy to understand (ETU) and not ready for change (RFC).
```
final double oneRevolution = 360.0;
final int numSides = 5;
final int sideLength = 36;
for (int i = 0; i < numSides; ++i) {
    turtle.forward(sideLength);
    turtle.turn(oneRevolution / numSides);
}
```
 Notice that comments weren’t needed to make the code clearer, just descriptive names.
This is:
- safer from bugs
- easier to understand
- more ready for change

## One purpose for each variable 
In the dayOfYear example, the parameter dayOfMonth is reused to compute a very different value — the return value of the function, which is not the day of the month.

***Don’t reuse parameters, and don’t reuse variables. Variables are not a scarce resource in programming. Introduce them freely, give them good names, and just stop using them when you stop needing them.***

- You will confuse your reader if a variable that used to mean one thing suddenly starts meaning something different a few lines down.
- Not only is this an ease-of-understanding question, but it’s also a safety-from-bugs and ready-for-change question.

***Method parameters, in particular, should generally be left unmodified.*** `myMethod(final int a, final String b)`
- This is important for being ready-for-change — ***in the future, some other part of the method may want to know what the original parameters of the method were***, so you shouldn’t blow them away while you’re computing.
- ***It’s a good idea to use*** `final` ***for method parameters***, and as many other variables as you can. 
- The `final` keyword says that ***the variable should never be reassigned, and the Java compiler will check it statically.***

***Example 1:***
```
public static int dayOfYear(final int month, final int dayOfMonth, final int year) {
    ...
}
```

## Smelly example 2: 
There was a latent bug in dayOfYear. It didn’t handle leap years at all. As part of fixing that, suppose we write a leap-year method.

```
public static boolean leap(int y) {
    String tmp = String.valueOf(y);
    if (tmp.charAt(2) == '1' || tmp.charAt(2) == '3' || tmp.charAt(2) == 5 || tmp.charAt(2) == '7' || tmp.charAt(2) == '9') {
        if (tmp.charAt(3)=='2'||tmp.charAt(3)=='6') return true; /*R1*/
        else
            return false; /*R2*/
    }else{
        if (tmp.charAt(2) == '0' && tmp.charAt(3) == '0') {
            return false; /*R3*/
        }
        if (tmp.charAt(3)=='0'||tmp.charAt(3)=='4'||tmp.charAt(3)=='8')return true; /*R4*/
    }
    return false; /*R5*/
}
```

Mental execution of code is a crucial part of reading and understanding code, and is often necessary in code review to help find bugs.

Characters in Java are numeric types, just like int and long, and automatically convert to integers when they need to.

**Magic numbers, exercise:**
How many magic numbers are in this code? Count every occurrence if some appear more than once.
- 24

Every expression of the form tmp.charAt(k) == 'n' has two magic numbers in it, k and n. There are twelve such expressions, so that makes 24 magic numbers.

Some of these numbers actually have type char instead of type int, but the type of the constant doesn’t particularly matter to the notion of a magic number. Character and string constants can be magical too, for the same reasons that numeric constants are magical: when their origin is obscure, or when their purpose in the computation is obscure, or when they have hidden dependencies on other constants.

## Use good names 
Good method and variable names are long and self-descriptive. Comments can often be avoided entirely by making the code itself more readable, with better names that describe the methods and variables.

**Example 1:**
```
int tmp = 86400;  // tmp is the number of seconds in a day (don't do this!)
// as:
final int secondsPerDay = 86400;
```
Every local variable is temporary, and every variable is data, so those names are generally meaningless. Better to use a longer, more descriptive name, so that your code reads clearly all by itself.

Global constants: `public static final` (SNAKE_CASE)
<br>Local constants: `public final` (camelCase)

In any language, ***method names are usually verb phrases***, like ***getDate or isUpperCase***, while ***variable and class names are usually noun phrases***. Choose short words, and be concise, but avoid abbreviations. 

**Avoid single-character variable names entirely except** where they are easily understood by convention. For example, x and y make sense for Cartesian coordinates, and i and j as integer variables in for loops.

**Using names that suggest their types** can be particularly good for the readability of dynamically-typed languages like Python and JavaScript, because they don’t have static types in variable declarations.

## Use whitespace to help the reader 
- Use consistent indentation.
- Put spaces within code lines to make them easy to read.
- Never use tab characters for indentation: 
  - Always set your programming editor to insert space characters when you press the Tab key.
  - Avoid inconsistencies.

## Smelly example 3:
```
public static int LONG_WORD_LENGTH = 5;
public static String longestWord;

public static void countLongWords(String text) {
    String[] words = text.split(' ');
    if (words.length == 0) {
        System.out.println("0");
        return;
    }
    int n = 0;
    longestWord = "";
    for (String word: words) {
        if (word.length() > LONG_WORD_LENGTH) ++n;
        if (word.length() > longestWord.length()) longestWord = word;
    }
    System.out.println(n);
}
```

## Don't use global variables 
**A global variable is:**
- a variable, a name whose value can be changed
- that is global, accessible and changeable from anywhere in the program.

Global variable: `public static`
- The *public* modifier makes it accessible anywhere, 
- and *static* means there is a single instance of the variable.
- ***Global variables are bad.*** https://wiki.c2.com/?GlobalVariablesAreBad

Global variable != Global constant

Global Constant: `public static final`

- A global constant can be read anywhere in the program but never reassigned or mutated, so the risks go away. ***Global constants are common and useful.***


## Kinds of variables in snapshot diagrams 
it’s important to distinguish between ***different kinds of variables:***
- a local variable inside a method
- an instance variable inside an instance of an object
- an instance variable may also be called a field (particularly in Java), a property (TypeScript/JavaScript), a member variable (C++), or an attribute (Python).
- a static variable associated with a class

***A local variable*** comes into existence when a method is called, and then disappears when the method returns. If multiple calls to the same method are in progress (for example because of recursion), then each call will have its own independent local variables.
```
class Payment {
    public double value; // init instance variable 
    public static void main(String[] args) {
        Payment p = new Payment();
        p.value = 100; 
        System.out.println(p.value);
    }
}

public class Main {
    public static int recursiveF(final int x) {
        System.out.println("in" + x);
        if (x <= 0 ) {
            return x;
        } else {
            int y = x - 1;
            System.out.println("out" + y);
            return recursiveF(y);
        }
    }
    public static void main(String[] args) {
        recursiveF(3);
    }
}
```
***An instance variable*** comes into existence when an object is created with new, and then disappears when the object is no longer accessible and becomes garbage-collected. Each object instance has its own instance variables.

***A static variable*** comes into existence when the program starts (or more precisely when the class containing the variable is first loaded, since that might be delayed), and exists for the rest of the life of the program.


## Methods should return results, not print then 
In general, **only the highest-level parts of a program should interact with the human user or the console.** ***Lower-level parts should take their input as parameters and return their output as results.***

The sole **exception** here is **debugging output**, which can of course be printed to the console. But that kind of output shouldn’t be a part of your design, only a part of how you debug your design.

## Avoid special-case code 

**Actively resist the temptation to handle special cases separately.** If you find yourself writing an if statement for a special case, stop what you’re doing, and instead think harder about the general-case code, either to confirm that it can actually already handle the special case you’re worrying about (which is often true!), or put in a little more effort to make it handle the special case. If you haven’t even written the general-case code yet, but are just trying to deal with the easy cases first, then you’re doing it in the wrong order. **Tackle the general case first.**
- It is likely to be safer from bugs, **because it makes fewer assumptions about the values it is working with.** And it is more ready for change, because there are fewer places to update when a change to the method’s behavior is made.

```
    {
    // This is the special case:
    if (words.size() == 0) {
        System.out.println(0);
        return;
    }
    int n = 0;
    longestWord = "";
    for (String word: words) {
        if (word.length() > LONG_WORD_LENGTH) ++n;
        if (word.length() > longestWord.length()) longestWord = word;
         }
   System.out.println(n);}
````
The special case code failed to clear the global variable longestWord, which does get cleared in other cases where the result is 0. This odd variation in behavior is likely to lead to unexpected bugs in code depending on this method.

Note that the best way to fix this is not to copy *longestWord = ""* into the special-case if statement. **Instead the special case should be deleted entirely.**

## Summary
Code review is a widely-used technique for improving software quality by human inspection. Code review can detect many kinds of problems in code, but as a starter, this reading talked about these general principles of good code:

- Don’t Repeat Yourself (DRY)
- Comments where needed
- Fail fast
- Avoid magic numbers
- One purpose for each variable
- Use good names
- Use whitespace to help the reader
- Don’t use global variables
- Methods should return results, not print them
- Avoid special-case code

The topics of today’s reading connect to our three key properties of good software as follows:

**Safe from bugs.** In general, code review **uses human reviewers to find bugs.** DRY code lets you fix a bug in only one place, without fear that it has propagated elsewhere. Documenting your assumptions with clear comments makes it less likely that another programmer will introduce a bug. The Fail Fast principle detects bugs as early as possible. Avoiding global variables makes it easier to localize bugs related to variable values, since non-global variables can be changed in only limited places in the code.

**Easy to understand.** Code review is really the only way to find obscure or confusing code, because other people are reading it and trying to understand it. Using judicious comments, avoiding magic numbers, keeping one purpose for each variable, using good names, and using whitespace well can all improve the understandability of code.

**Ready for change.** Code review helps here when it’s done by experienced software developers who can anticipate what might change and suggest ways to guard against it. DRY code is more ready for change, because a change only needs to be made in one place. Returning results instead of printing them makes it easier to adapt the code to a new purpose.