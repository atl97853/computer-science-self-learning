Welcome to the second half of 61B. 

Previously, we have focused on how to save time writing the program. 
Now, we will learn how to *make the best use of our computer's time and memory.*

Programming cost (everything in the course up to this date). 
Execution cost: 
- Time complexity: How much time does it take for your program to execute? 
- Space complexity: How much memory does your program require? 

This chapter will provide you the formal techniques and tools to compare the efficiency of various 
algorithms!. 

Rather than physically timing the amount of time it takes for the algorithm to run, we can instead
count the total number of operations completed by each algorithm! 

In most applications, we are most concerned about what happens for very large values of N. 
This is known as the asymptotic behavior. We want to learn what types of algorithms are able
to handle large amounts of data. 

Simplication summary: 
1.- Only consider the worst case. 
2.- Pick a representative operation. (a.k.a. the cost model). 
3.- Ignore lower order terms. 
4.- Ignore multiplicative constants. 

Good choice: 
- Increment, less than, equals, array accesses 
(The part of the program which takes the most amount of time is generally 
assumed to be the order of growth). 
Bad choice: 
- Assigment, of j = i + 1, i = 0 

To summarize this chapter: 
Given a piece of code, we can express its runtime as a function R(N)R(N)
- N is a *property* of the input of the function often representing the 
*size* of the input.
Rather than fiding the exact value of R(N), we only worry about fiding the 
*order of growth* of R(N). 

One approach (not universal):
1.- Choose a representative operation. 
2.- Let C(N) be the count of how many times that operation occurs as a function
of N. 
3.- Determine order of growth f(N) for c(N), example: C(N)=/ O(f(N)).
4.- Often (but now always) we consider the worst case count. 
5.- If operation takes constant time, then R(N) =/ O(f(N)).
