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
- Formal reasoning about a program: usually called verfication, it constructs a formal proof that a program is correct. 
- Code review, it will be discussed in the next reading class. 
- Testing: running the program on carefully selected inputs and checking the results. 

<br>Even with the best validation, it's very hard to achieve perfect quality in software. 
<br>Here are some typical residual defect rates (bugs left over after the software has shipped) per kloc (one thousand lines of source code): 

- 1 - 10 defects/kloc: Typical industry software.
- 0.1 - 1 defects/kloc: High-quality validation. The Java libraries might achieve this level of correctness. 
- 0.01 - 0.1 defects/kloc: The very best, safety-critical validation. Nasa and companies like Praxis can achieve this level. 

<br>*Example*: 
<br>If you have shipped a million lines of typical industry source code (1 defect/kloc), it means you missed 1000 bugs! 

**Why software testing is hard**