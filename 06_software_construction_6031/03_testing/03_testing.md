# Reading 3: Testing

<br>***Objective***
<br>After today's class, you should:
- understand the value of testing, and know the process of test-first programming;
- be able to suite a test suite for correctness, thoroughness, and size;
- be able to design a test suite for a method by partitioning its input space and choosing good test cases;
- be able to judge a test suite by measuring its code coverage;
- understand and know when to use black box vs. glass box testing, unit tests vs. integration tests, and automated regression testing. 
  
## Validation
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

## Why software testing is hard

*Here are some approaches that unfortunately don't work well in the world of software:*

- **Exhaustive testing** is infeasible, the space of possible test cases is generally too big to cover exhaustively. 
- **Haphazard testing** is *less likely to find bugs*, unless the program is so buggy that an arbitrarily-chosen input is more likely to fail than to succeed. It also doesn't increase our confidence in program correctness. 
- **Random or statistical testing** doesn't work well for software, as in physical systems. Software behavior varies discontinuously and discretely across the space of possible inputs, the system may seem to work fine across a broad range of inputs, and then abruptly fail at a single boundary point. 

*Instead, test cases must be chosen carefully and systematically.*

*Testing all inputs is not feasible, beacuse even one 64-bit floating point number has 2^64 possible values, which is more than age of the universe in microseconds*

## Test-first programming
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
<br>***Once your implementation passes the tests you wrote, you're done.***

<br>*The biggest benefit of test-first programming is safety from bugs*. 
<br>Don't leave testing until the end of development, when you have a big pile of unvalidated code. *Leaving testing until the end only makes debugging longer and more painful, because bugs may be anywhere in your code.*
<br>It's far more pleasant to test your code as you develop it. 

*some notes*: 
- *method signature consists of the method's name, parameter types, and return type, which are all part of the specification.*
- *every test case is a ***client*** of the module.*

## Systematic testing
Rather than exhaustive, haphazard, or randomized testing, we want to test *systematically*.
<br>Systematic testing means that we are choosing test cases in a principled way, with the goal of designing a test suite with three desirable properties: 
- **Correct**, *a correct test suit is a legal client of the specification*, and *it accepts all legal implementations of the spec without any complaint.*
  - *This give us the freedom to change how the module is implemented internally without necessarily having to change the test suite.* 
- **Thorough**, a thorough test suite *finds actual bugs* in the implementation, caused by mistakes that programmers are likely to make. 
- **Small**, *a small test suite, with few test cases*, is faster to write in the first place, *and easier to update if the specification evolves*.
  - Small test suites are alse faster to run, you will be able to run your tests more frequently if your test suites are small and fast. 

<br>By these criteria, exhaustive testing is thorough but infeasibly large, haphazard testing tends to be small but not thorough, randomized testing can achieve thoroughness only at the cost of large size. 
<br>You have to make the test suite design wanting to make your code fail, *test-first programming* allows you to put on your testing hat, and adopt that brutal perspective, before you've even written any code. 

**examples**:
- A test suite is *correct* if: all its test cases pass when run on a legal implementation (failing on buggy implementations is also desirable, of course, but that is thoroughness, not correctness).
- A test suite T1 is more thorough than a test suite T2 if: the buggy implementations that fail at least one test in T1 is a strict superset of those that fail at least one test in T2 (if T1 rejects a superset of buggy implementations compared to T2, the T1 is more thorugh than T2), (redundant test cases might be larger, but they find the same bugs, accept more legal implementations means to be correct not thorough).
- An empty test suite contains no test cases. Assuming a nontrivial specification, an empty test suite is: correct and small, but not thorough, it might passes all legal implementations and be as small as possible, but it alse passes buggy implementations, so it is not thorough. 

## Choosing test cases by partitioning
We want to pick a set of test cases that is small enough to be easy to write and maintain and quick to run, yet thorough enough to find bugs in the program. 
<br>**Todo this**: 

- <ins>we divide the input space into subdomains, each consisting of a set of inputs</ins>
- <ins>taken together, the subdomains form a partition:</ins> 
- <ins>a collection of disjoint sets that completely covers the input space</ins> 
- <ins>so that every input lies in exactly one subdomain</ins> 
- <ins>then we choose one test case from each subdomain, and that's our test suite</ins> 

<br>subdomains are not the same as test cases. 
<br>*subdomains* = are set inputs from which test cases are chosen.
<br>*test suit = set of test cases* * 

<br>**Test suites** = group related test cases.
<br>***Partitions*** = categorize possible inputs.
<br>***Subdomains*** = are refinements within partitions.
<br>***Test cases*** = are specific scenarios with defined inputs, outputs, and steps, (particular choice of inputs).

- ***Test suit -> partitions -> subdomains -> test cases***
- The idea behind subdomains is to dived the input space into sets of similar inputs on which the program has similar behavior.
- Then we use one representative of each set.
- *a partition* must completely cover the set of possible inputs.
  
*This approach makes the best use of limited testing resources by choosing dissimilar test cases, and forcing the testing to explore areas of the input space that random testing might not reach.*

<br>**example 1**:

```
/**
 * ...
 * @param a  an argument
 * @param b  another argument
 * @return the larger of a and b.
 */
public static int max(int a, int b)
```
<br>`max int x int -> int`
- We have a two-dimensional *input space*, consisting of all the pairs of integers (a,b), now let's partition it: 
- from the specification, it makes sense to choose the subdomains: `{(a,b)|a < b} and {(a,b)|a > b}`
- but we can't stop there, because these subdomains are not yet a partition of the input space 
- ***a partition must completely cover the set of possible inputs***, so we need to add `{(a,b)|a = b}`
<br>Expressed compactly, the partition looks like this: `// partition: a < b; a > b; a = b`
<br>Out test suite might the be: 
- `(a,b) = (1,2) to cover a < b`
- `(a,b) = (10,-8) to cover a > b`
- `(a,b) = (9,9) to cover a = b`

**example 2**:
<br>*suppose you want to partition the input space of this integer square root function*
```
/**
 * @param x   must be nonnegative
 * @returns nearest int to the square root of x
 */
public static int sqrt(int x)
```
Evaluate the quality of each of the following candidate partitions 
- Are the proposed subdomains disjoint and complete, thus forming a partition? 
- Are they correct, in the sense that each subdomain can be covered by a legal test case? 
<br>*A good partition should check all three boxes*
<br>`// partition: x < 0; x >= 0` *(subdomains are: disjoint and complete, not correct)*.
- The proposed subdomains are disjoint, and their union covers the input space of the function, so they form a partition.
- But x < 0 is not a correct subdomain because it consists entirely of ilegal inputs, so it would not be possible ot choose a correct test case to cover this subdomain.
<br>`// partition: x is a pefect square; x is an integer > 0 but not a perfect square` *(subdomains are: disjoint, complete, correct).*
- The two proposed subdomains are disjoint. 
- Their union covers the input space of the function (including 0, which is a perfect square).
- They include no ilegal inputs, so they form a correct partition.
- This is likely to be useful partition, in the sense of separating inputs with different behavior, because the function returns an exact answer on the first subdomain but a rounded answer on the second.
<br>`// partition: x = 0, x = 1, x = 7, x = 16` *(subdomains are: disjoint, correct, not complete).*
- These four proposed subdomains are singleton sets, which are disjoint but do not completely cover the input space. 
- All of them are correct inputs.
- This example looks like a set of candidate test cases that have been proposed as a partition, which is a common confusion. 
- ***Subdomains are not the same as test cases.***
- ***Subdomains are sets of inputs from which test cases are chosen.***
- Some subdomains may be singletons (like boundary values), but most are not.

<br>**example 3:**
```
/**
 * @param x an integer
 * @param y an integer, where x and y are not both 0
 * @return the greatest common divisor of x and y
 */
public static int gcd(int x, int y);
```
`// partition: x and y are not both 0` *(subdomains are: disjoint, complete, correct).*
- This is a single subdomain, `{(x,y)| x and y are not both 0}`
- This is indeed a partition, because it covers the entire domain, but it's unlikely to be useful for producing a thotough test suite, however.
<br>`// partition: x is divisible by y; y is divisible by x; x and y are relatively prime` *(subdomains are: correct, but not disjoint, complete).*
- The three subdomains are not disjoint, for example, any point such that x = y belongs to both of the first two, and x = y = 1 belongs to all three. 
- The subdomains are not complete because they don't cover a point like x = 6, y = 8, where x and y are not relatively prime but also neither is a factor of the other.
- The subdomains are, however, correct, because each one contains at least one legal test case. 
- This partition could be imporved into a complete disjoint, and useful partition for gcd

**Include boundaries in the partition**
- *A **boundary** value is a data value that corresponds to a minimum or maximum input, internal, or output value specified for a system or component.*
- *Bugs often occur at boundaries between subdomains.*
  - 0 is a boundary between positive numbers and negative numbers. 
  - the maximum and minimum values of numeric types, like int or double.
  - emptiness for collection types, like the empty string, empty list, or empty set, (for example empty string) 
  - the first and last element of a sequence, like a string or list. 
  
<br>**Example 1:**
```
/**
 * @param winsAndLosses  a string of length at most 5 consisting of 'W' or 'L' characters
 * @return the fraction of characters in winsAndLosses that are 'W'
 */
double winLossRatio(String winsAndLosses);
```
Boundaries: 
- `""`, the empty string is always a good boundary value, as are other minimums like 0 or the empty list
- `"LLLLL"` and `WWWWW`, maximums also produce good boundary values, in this case, maximizing the number of W characters, and also maximizing the number of L characters

**Example 2, BigInteger.multiply**
```
// specification: 
/**
 * @param val another BigInteger
 * @return a BigInteger whose value is (this * val).
 */
public BigInteger multiply(BigInteger val)
```
For example, here's how it might be used: 
```
BigInteger a = new BigInteger("9500000000"); // 9.5 billion
BigInteger b = new BigInteger("2");
BigInteger ab = a.multiply(b); // should be 19 billion
```
This method is using the self-object as a second parameter, although there is only one parameter explicitly shown in the method's declaration, *multiply is actually a function of two arguments:* the object you're calling the method on `a`, and the parameter that you're passing in the parenthesses `b`.
<br>`multiply: BigInteger x BigInteger -> BigInteger`
- We have a two-dimensional input space, consisting of all the pairs of integers (a,b)
- Thinking about how *sign rules* work with multiplication, *we might start with these subdomains*:
  - a and b are both positive 
  - a and b are both negative 
  - a is positive, b is negative 
  - a is negative, b is positive
  
- There are also some boundary values for multiplication that we should check: 
  - a or b is 0, because the result is always 0
  - a or b is 1, the identity value for multiplication 

- Finally, because the purpose of BigInteger is to represent arbitrarily-large integers, we should make sure to try integers that are very big, at least bigger than the biggest *long*, which is roughly 2<sup>63</sup>, a 19-digit decimal integer
  - a or b is small or large in magnitude, (small enough to represent in a *long* value, or too large for a long)

<br>Let's bring all these observations together into a single partition of the whole (a,b) space, we'll choose a and b independently from: 
- 0
- 1
- small positive integer (≤ Long.MAX_VALUE and > 1)
- small negative integer (≥ Long.MIN_VALUE and < 0)
- large positive integer (> Long.MAX_VALUE)
- large negative integer (< Long.MIN_VALUE)

<br>***so this would produce 6 x 6 = 36 subdomains that pastition the space of pairs of integers***
<br>***to produce the test suite from this partition, we would pick an arbitrary pair (a,b) from each square of the grid:***

- (a,b) = (0, 0) to cover (0, 0)
- (a,b) = (0, 1) to cover (0, 1)
- (a,b) = (0, 8392) to cover (0, small positive integer)
- (a,b) = (0, -7) to cover (0, small negative integer)
- …
- (a,b) = (-1060, -10810) to cover (large negative, large negative)


**Using multiple partitions**
- For functions with multiple parameters, this can become costly.
- Each parameter may have interesting behavior variation and several boundary values, so forming a single partition of the input space from the *Cartesian product* of the behavior on each parameter, leads to a combinatorial explosion in the size of the resulting test suite 
- in the `.multiply()` example, the *Cartesian product partition* had 6 x 6 = 36 subdomains, requiring 36 test cases to cover
- for a function with *n* parameters, the *Cartesian product* approach produces a test suite of size exponential in *n*, which quickly becomes infeasible for manual test authoring 

<br>***An alternative approach is to treat the features of each input a and b as two separate partitions of the input space.***
- One partition only considers the values of a: 
  - (a,b) such that a = 0, 1, small positive, small negative, large positive, large negative 
- And the other partition only considers the value of b:
  - (a,b) such that b = 0, 1, small positive, small negative, large positive, large negative 

<br>*every input pair (a,b) belongs to exactly one subdomain from each partition*
<br>the two partitions compactly:
```
// partition on a:
//   a = 0
//   a = 1
//   a is small integer > 1
//   a is small integer < 0
//   a is large positive integer
//   a is large negative integer
//      (where "small" fits in long, and "large" doesn't)

// partition on b:
//   b = 0
//   b = 1
//   b is small integer > 1
//   b is small integer < 0
//   b is large positive integer
//   b is large negative integer
```
***We still want to cover every subdomain with a test case, but now a single test case can cover multiple subdomains from different partitions, making the the suite more efficient.***

<br>Partitioning *a* and *b* independently raises the risk that you're no longer testing the interaction between them. 
- sign handling in multiplication is a possible source of bugs, and the sign of the result depends on the signs of both *a* and *b*.
- but we can add an additional partition that captures this interaction:
```
// partition on signs of *a* and *b:*
//    a and b are both positive
//    a and b are both negative
//    a positive and b negative
//    a negative and b positive
//    one or both are 0
```
*Now we have three partitions, with 6, 6, and 5 subdomains each, but we don't need the Cartesian product of 6 x 6 x 5 test cases to cover them. **A test suit with 6 carefully-chosen test cases can cover the subdomains of all three partitions.***
- ***Test suit -> partitions -> subdomains -> test cases***
- We can continue to add partitions this way, as we think more about the spec and observe other behavioral variations that might lead to bugs. 
- With careful test case selection, additional partitions should require few (if any) additional test cases.
- Sometimes we may want to use the Cartesian product approach on multiple partitions, to produce a more thorough test suite. But even in those cases, the Cartesian product may be smaller than we expect. 
- When subdomains from different partitions turn out to be mutually exclusive, the Cartesian product won't include a subdomains for that particular combination of subdomains. 

<br>***As stating point for test-first programming, a small test suite that covers each subdomain of several thoughtfully-chosen partitions strikes a good balance between size and thoroughness.***
- The test suite may then grow further with glass box testing, code coverage measurement, and regression testing, which we'll see later in this reading. 

<br>**Example 1:** 
```
/**
 * Reverses the end of a string.
 *
 *                          012345                     012345
 * For example: reverseEnd("Hello, world", 5) returns "Hellodlrow ,"
 *                               <----->                    <----->
 *
 * With start == 0, reverses the entire text.
 * With start == text.length(), reverses nothing.
 *
 * @param text    string that will have its end reversed
 * @param start   the index at which the remainder of the input is reversed,
 *                requires 0 <= start <= text.length()
 * @return input text with the substring from start to the end of the string reversed
 */
public static String reverseEnd(String text, int start)
```
Partitions for the start parameter:
<br>`start = 0; 0 < start < text.length(); start = text.length()`
- ***A partition should be a division of the whole space of possible start values, not specific test cases.***
- ***A test case must obey the requirements of the funtion's specifications.***
  
<br>Partitions for the text parameter: 
<br>`text.length() = 0; text.length() > 0`
<br>`text.length() = 0; text.length()-start is odd; text.length()-start is even (> 0)`
- Legth is a useful partition, however, since it can interact with the start parameter.
- Partitioning on even and odd length is also reasonable, because reversing an odd-length substring has different behavior (since it leaves the middle element in place).

**Extra: Clarification on how the concepts relate to each other:**
- Test Suites are not directly made from partitions or subdomains:
  - Test suites are collections of test cases, not partitions or subdomains themselves.
  - However, test cases are often designed based on partitions and subdomains to ensure comprehensive coverage.
- Partitions are not necessarily made from subdomains:
  - Partitions are the broader categories for grouping inputs.
  - Subdomains are further refinements within a partition to represent specific variations.
  - A partition might not require subdomains if the category itself is clear-cut (e.g., valid login credentials).
- Test Cases are not the same as subdomains:
  - Subdomains define specific variations within a partition.
  - Test cases use a specific scenario within a subdomain to define the actual inputs, outputs, and steps for testing.
  - Multiple test cases can be created from a single subdomain to explore different scenarios within that variation.

## Automated unit testing with JUnit
-A well-tested program will have tests for every individual module that it contains.
<br>-A test that tests an individual module, in isolation if possible, is called a unit test. 
<br>-JUnit is a widely-adopted Java unit testing library, it will be used heavily in 6.031
- A JUnit unit test is written as a method preceded by the annotation `@Test`.
- A unit test method typically contains one or more calls to the module being tested, and then checks the results using assertion methods like `assertEquals` , `assertTrue`, and `assertFalse` .
- The order of the parameters is important: `assertEquals(expected result, actual result);`
  - The first parameter should be the *expected* result, usually a constant.
  - The second parameter is the *actual* result, what the code actually does. 
  - An assertion can also take an optional message string as the last argument, which you can use to make the test failure clearer.
- If an assertion in a test method fails, then that test method returns immediately, and JUnit records a failure for that test.
- A test class can contain any number of `@Test` methods
  - which are run independently when you run the test class JUnit, even if one test method fails, the others will still be run. 

**Example 1**:
```
public class AbsTest {
  @Test
  public void test() {
    int result = Math.abs(-3);
    assertEquals(3, result);
  }
}
```
The value expected by the test, in this case 3, should be the first argument of assertEquals. The value actually returned by the module under test, result, should be the second argument. This allows JUnit to display understandable information to the programmer when the test fails:
<br>`AssertionFailedError: expected: <3> but was: <-3>`
<br>If the parameters to assertEquals are in the wrong order, this message will be very misleading. 

<br>**Example 2:**
<br> This test is intended to test a method pickRandomly() that picks random number from its set.
```
@Test
public void testDrawFromSet() {
  Set<Integer> set = Set.of(293, 10, -3, 99);
  int result = pickRandomly(set);
}
```
Every assertion method accepts an optional *message argument*, this assertion is correct and useful for debugging:
<br>`assertTrue(set.contains(result), "expected result to be from" + set + "but actually was" + result);`
<br>`AssertionFailedError: expected result to be from [293, 10, -3, 99] but actually was 0 ==> expected: <true> but was <false>`

## Documenting your testing stragegy 
It's a good idea to write down the testing strategy you used to create a test suite: ***the partitions, their subdomains, and which subdomains each test case was chosen to cover.***
<br>Document the **partitions** and **subdomains** in a comment at the top of the **JUnit test class**:
```
public class MaxTest {
  /*
   * Testing strategy
   *
   * partition:
   *    a < b
   *    a > b
   *    a = b
   */
```
Each **test case** should have a comment above it saying which **subdomain** it covers:
```
  // covers a < b
  @Test
  public void testALessThanB() {
      assertEquals(2, Math.max(1, 2));
  }
```
***Most test suites will have more than one partition, and most test cases will cover multiple subdomains:***
```
public class Multiply {
  /*
   * Testing strategy
   *
   * cover the cartesian product of these partitions:
   *   partition on a: positive, negative, 0
   *   partition on b: positive, negative, 0
   *   partition on a: 1, !=1
   *   partition on b: 1, !=1
   *   partition on a: small (fits in a long value), or large (doesn't fit)
   *   partition on b: small, large
   * 
   * cover the subdomains of these partitions:
   *   partition on signs of a and b:
   *      both positive
   *      both negative
   *      different signs
   *      one or both are 0
   */
```
Then every **test case** has a comment identifying the **subdomains** that it was chosen to cover:
```
  // covers a is positive, b is negative, 
  //        a fits in long value, b fits in long value,
  //        a and b have different signs
  @Test
  public void testDifferentSigns() {
      assertEquals(BigInteger.valueOf(-146), BigInteger.valueOf(73).multiply(BigInteger.valueOf(-2)));
  }

  // covers a = 1, b != 1, a and b have same sign
  @Test
  public void testIdentity() {
      assertEquals(BigInteger.valueOf(33), BigInteger.valueOf(1).multiply(BigInteger.valueOf(33)));
  }
```

## Black box and glass box testing 
**Black box testing:**
- *means choosing test cases only from the specification*, not the implementation of the function. 
- we partitioned and looked for boundaries, without looking at the actual code. 
- following the *test-first programming approach*, we hadn't even written the implementation.

<br>**Glass box testing:**
- means *choosing test cases with knowledge of how the function is actually implemented* 
- when doing glass box testing, you must take care that your test cases don't *require specific implementation behavior that isn't specifically called for by the spec. 
  - **example:** if the spec says "throws an exception if the input is poorly formatted", then your test shouldn't check specifically for a `NullPointerException` just because that's what the current implementation does. 
  - the specification in this case allows *any* exception to be thrown, so your test case should likewise be general in order to be correct and preserve the implementor's freedom. 

## Coverage 
One way to judge a test suite is to ask how thoroughly it exercises the program. This notion is called ***coverage***. Here are three common kinds of coverage: 
- **Statement coverage**: is every statement run by some test case? 
- **Branch coverage**: for every if or while statement in the program, are both the true and the false direction taken by some test case? 
- **Path coverage**: is every possible combination of banches (every path through the program) taken by some test case? 

<br>**Branch coverage**  is stronger (requires more tests to achieve) than **statement coverage**, and **path coverage** is stronger than **branch coverage**.
- In industry, 100% **stament coverage** is a common goal, but even that is rarely achieved due to unreachable defensive code (like "should never get here" assertions).
- 100% **branch coverage** is highly desirable, and safety critical industry code has even more arduos criteria. 
- Unfortunately 100% path coverage is infeasible, requiring exponential-size test suites to achieve. 

<br>A standard approach to testing is to add tests until the test suite achieves adequate statement coverage
- so that every reachable statement in the program is executed by at least one test case. 
- in practice, statement coverage is usually measured by a code coverage tool, which counts the number of times each statement is run by your test suite. 
- with such a tool, glass box testing is easy, you just measure the coverage of your black box tests, and add more test cases until all important statements are logged as executed. 