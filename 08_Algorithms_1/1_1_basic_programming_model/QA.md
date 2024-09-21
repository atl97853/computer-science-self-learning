# 1.1 Basic Programming Model Q&A

**Q. What is Java bytecode?**

A low-level version of your program that runs on the Java virtual machine. This level of abstraction makes it easier for the developers of Java to ensure that our programs run on a broad variety of devices. (binary version of the program)

**Q. It seems wrong that Java should just let ints overflow and give bad values. Shouldn’t Java automatically check for overflow?**

This issue is a contentious one among programmers. The short answer is that the lack of such checking is one reason such types are called primitive data types. A little knowledge can go a long way in avoiding such problems. We use the int type for small numbers (less than ten decimal digits), and the long type when values run into the billions or more.

**Q. What is the value of Math.abs(-2147483648)?**

-2147483648. This strange (but true) result is a typical example of the effects of integer overflow.

**Q. How can I initialize a double variable to infinity?**

Java has built-in constants available for this purpose: Double.POSITIVE_INFINITY and Double.NEGATIVE_INFINITY.

**Q. Can you compare a double to an int?**

Not without doing a type conversion, but remember that Java usually does the requisite type conversion automatically. For example, if x is an int with the value 3, then the expression (x < 3.1) is true—Java converts x to double (because 3.1 is a double literal) before performing the comparison.

**Q. What happens if I use a variable before initializing it to a value?**

Java will report a compile-time error if there is any path through your code that would lead to use of an uninitialized variable.

**Q. What are the values of 1/0 and 1.0/0.0 as Java expressions?**

The first generates a runtime exception for division by zero (which stops your program because the value is undefined); the second has the value Infinity.

**Q. Can you use < and > to compare String variables?**

No. Those operators are defined only for primitive types.

**Q. What is the result of division and remainder for negative integers?**

The quotient a/b rounds toward 0; the remainder a % b is defined such that (a / b) * b + a % b is always equal to a. For example, -14/3 and 14/-3 are both -4, but -14 % 3 is -2 and 14 % -3 is 2.

**Q. Why do we say (a && b) and not (a & b)?**

The operators &, |, and ^ are bitwise logical operations for integer types that do and, or, and exclusive or (respectively) on each bit position. Thus the value of 10&6 is 2, the value of 10|6 is 14 and the value of 10^6 is 12. We use these operators rarely (but occasionally) in this book. The operators && and || are valid only in boolean expressions are included separately because of short-circuiting: an expression is evaluated left-to-right and the evaluation stops when the value is known.

**Q. Is ambiguity in nested if statements a problem?**

Yes. In Java, when you write
`if <expr1> if <expr2> <stmntA> else <stmntB>`
it is equivalent to
`if <expr1> { if <expr2> <stmntA> else <stmntB> }`
even if you might have been thinking
`if <expr1> { if <expr2> <stmntA> } else <stmntB>`
Using explicit braces is a good way to avoid this dangling else pitfall.

**Q. What is the difference between a for loop and its while formulation?**

The code in the for loop header is considered to be in the same block as the for loop body. In a typical for loop, the incrementing variable is not available for use in later statements; in the corresponding while loop, it is. This distinction is often a reason to use a while instead of a for loop.

**Q. Some Java programmers use int a[] instead of int[] a to declare arrays. What’s the difference?**

In Java, both are legal and equivalent. The former is how arrays are declared in C. The latter is the preferred style in Java since the type of the variable int[] more clearly indicates that it is an array of integers.

**Q. Why do array indices start at 0 instead of 1?**

This convention originated with machine-language programming, where the address of an array element would be computed by adding the index to the address of the beginning of an array. Starting indices at 1 would entail either a waste of space at the beginning of the array or a waste of time to subtract the 1.

**Q. If a[] is an array, why does StdOut.println(a) print out a hexadecimal integer, such as @f62373, instead of the elements of the array?**

Good question. It is printing out the memory address of the array, which, unfortunately, is rarely what you want.

**Q. Why are we not using the standard Java libraries for input and graphics?**

We are using them, but we prefer to work with simpler abstract models. The Java libraries behind StdIn and StdDraw are built for production programming, and the libraries and their APIs are a bit unwieldy. To get an idea of what they are like, look at the code in StdIn.java and StdDraw.java.

**Q. Can my program reread data from standard input?**

No. You only get one shot at it, in the same way that you cannot undo println().

**Q. What happens if my program attempts to read after standard input is exhausted?**

You will get an error. StdIn.isEmpty() allows you to avoid such an error by checking whether there is more input available.

**Q. What does this error message mean?** `Exception in thread "main" java.lang.NoClassDefFoundError: StdIn`

You probably forgot to put StdIn.java in your working directory.

**Q. Can a static method take another static method as an argument in Java?**

No. Good question, since many other languages do support this capability.

