## How Memoization technique is used in Dynamic Programming? 

Dynamic programming helps to efficiently solve problems that have overlapping subproblems and optimal substructure properties. 
The idea behind dynamic programming is to break the problem into smaller sub-problems and save the result for future use, thus 
eliminating the need to compute the result repeatedly. 

There are two approaches to formulate a dynamic programming solution: 

- **Top-Down Approach:** This approach follows the **memoization** technique. It consists of **recursion** and **caching**. In computation, recursion represents the process of calling functions repeatedly, whereas caches refers to the process of storing intermediate results. 
- **Bottom-Up Approach:** This approach uses the **tabulation** technique to implement the dynamic programming solution. It addresses the same problems as before, but without recursion. In this approach, iteration replaces recursion. Hence there is no stack overflow error or overhead of recursive procedures. 

## Should I use tabulation or memoization? 

For problems requiring all subproblems to be solved, tabulation typically outperforms memoization by a constant factor. This is because the tabulation has no overhead of recursion which reduces the time for resolving the recursion call stack from stack memory. 

Whenever a subproblem needs to be solved for the original problem to be solved, memoization is preferable since a subproblem is solved lazily, the computations that are required are carried out. 

## Notes for ex_1_1_19.java/ Fibonacci Sequence.  

Memoization is an optimization technique used to speed up computer programs by **caching** the results of **expensive function calls**. 

Solving the same problem again and again takes time and increases the run-time complexity of the overall program. This can be resolved by maintaining some cache or memory where we will store the already calculated result of the problem for some particular input. 

**So that if we don't want to recalculate the same problem, we can simply use the result that is stored in the memory and reduce the time complexity.**

**Memoization is a technique in computer science to speed up the execution of recursive or computationally expensive functions by caching the results of function calls returning the cached results when the same inputs occur again.**

This technique can save computation time, especially for functions that are called frequently or have a high time complexity. 

## Here's a step-by-step guide to implementing memoization: 

Identify the funtion that you want to optimize using memoization. This function should have repeated and expensive computations for the same input.

Create a dictionary object (**memoization table**) to store the cached results of the function. They keys of the dictionary should be the input parameters to the function, and the values be the computed results.

At the beginning of the function, check if the input parameters are already present in the cache dictionary. If they are, return the cached result. 

If the input parameters are not in the cache dictionary, compute the result and store it in the cache dictionary with the input parameters as the key. 

Return the computed result. 

### Conclusion 


## How Does Dynamic Programming (DP) Work?

**Identify Subproblems**: Divide the main problem into smaller, independent subproblems.

**Store Solutions**: Solve each subproblem and store the solution in a table or array.

**Build Up Solutions**: Use the stored solutions to build up the solution to the main problem.

**Avoid Redundancy**: By storing solutions, DP ensures that each subproblem is solved only once, reducing computation time.


## Tabulation vs Memoization 
https://www.geeksforgeeks.org/tabulation-vs-memoization/

**Memoization**:
- Top-down approach
- Caches the results of function calls
- Recursive implementation
- Well-suited for problems with a relatively small set of inputs
- Used when the subproblems have overlapping subproblems

**Tabulation**:
- Bottom-up approach
- Stores the results of subproblems in a table
- Iterative implementation
- Well-suited for problems with a large set of inputs
- Used when the subproblems do not overlap


## Exceptions 

Any recursive function that doesn’t make identical recursive calls at some point won’t benefit from this approach (memoization/cache). 