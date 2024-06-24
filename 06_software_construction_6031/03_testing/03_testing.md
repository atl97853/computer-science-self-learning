## Reading 3: Testing

<br>***Objective***
<br>After today's class, you should:
- understand the value of testing, and know the process of test-first programming;
- be able to suite a test suite for correctness, thoroughness, and size;
- be able to design a test suite for a method by partitioning its input space and choosing good test cases;
- be able to judge a test suite by measuring its code coverage;
- understand and know when to use black box vs. glass box testing, unit tests vs. integration tests, and automated regression testing. 
  
**Validation**
<br>*Testing is an example of a more general process called **validation***. 
<br>The *purpose* of validation is to uncover problems in a program and thereby increase your confidence in the program's correctness. (Correctness: *one that does exactly what its designers and users intend it to do – no more and no less.* )

<br>Validation includes: 
- **Formal reasoning** about a program: usually called verfication, it constructs a formal proof that a program is correct. 
- **Code review**, it will be discussed in the next reading class. 
- **Testing**: running the program on carefully selected inputs and checking the results. 

<br>Even with the best validation, it's very hard to achieve perfect quality in software. 
<br>Here are some typical residual defect rates (bugs left over after the software has shipped) per kloc (one thousand lines of source code): 

- 1 - 10 defects/kloc: Typical industry software.
- 0.1 - 1 defects/kloc: High-quality validation. The Java libraries might achieve this level of correctness. 
- 0.01 - 0.1 defects/kloc: The very best, safety-critical validation. Nasa and companies like Praxis can achieve this level. 

<br>*Example*: 
<br>If you have shipped a million lines of typical industry source code (1 defect/kloc), it means you missed 1000 bugs! 

**Why software testing is hard**

*Here are some approaches that unfortunately don't work well in the world of software:*

- **Exhaustive testing** is infeasible, the space of possible test cases is generally too big to cover exhaustively. 
- **Haphazard testing** is *less likely to find bugs*, unless the program is so buggy that an arbitrarily-chosen input is more likely to fail than to succeed. It also doesn't increase our confidence in program correctness. 
- **Random or statistical testing** doesn't work well for software, as in physical systems. Software behavior varies discontinuously and discretely across the space of possible inputs, the system may seem to work fine across a broad range of inputs, and then abruptly fail at a single boundary point. 

*Instead, test cases must be chosen carefully and systematically.*

*Testing all inputs is not feasible, beacuse even one 64-bit floating point number has 2^64 possible values, which is more than age of the universe in microseconds*

**Test-first programming**
- **Module**, it's a part of a software system that can be designed, implemented, tested, and reasoned about separately from the rest of the system. 
  - *in this reading, we'll focus on modules that are functions, represented by java methods, in future readings, we'll broaden our view to think about larger modules, like a class with multiple interacting mehods.*
- **Specification/spec**, it describes the behavior of a module. 
  - for a function, the specification gives *the types of the parameters and any additional constraits on them*, it also gives *the type of the return value and how the return value relates to the inputs*, in Java code, *the specification consists of the method signature and the comment above it that describes what it does.*
- a module has an **implementation**, that provides its behavior, and clients that use the module. 
  - for a function, *the implementation is the body of the method*, an the clients are other code that calls the method, *the specification of the module constrains both the client and the implementation*. 
- a **test case** is a particular choice of inputs, along with the expected output behavior required by the specification. 
- a **test suite** is a set of test cases for a module. 

**This is a good pattern to follow when designing a program from scratch, in test-first programming, you write the spec and the tests before you even write any code, the development of a single functions proceeds in this order:**
- **Spec**: write a specification for the function. 
- **Test**: write tests that exercise the specification. 
- **Implement**: write the implementation. 
<br>Once your implementation passes the tests you wrote, you're done. 

<br>*The biggest benefit of test-first programming is safety from bugs*. 
<br>Don't leave testing until the end of development, when you have a big pile of unvalidated code. *Leaving testing until the end only makes debugging longer and more painful, because bugs may be anywhere in your code.*
<br>It's far more pleasant to test your code as you develop it. 