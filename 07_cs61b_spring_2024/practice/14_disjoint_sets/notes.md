Goal: Design an efficient DisjointSets implementation. 
- Number of elements N can be huge. 
- Number of method calls M can be huge. 
- Calls to methods may be interspersed (e.g. can't assume it's only connect operations
followed by only isConnected operations). 

For each item, its connected component is the set of all items that are connected to 
that item. 

We will discuss four iterations of a Disjoint Sets design before being satisfied. 
Implementation, Constructor, connect(), isConnected. 
- *Quick Find*: Theta(N), O(N), O(N)
- *Quick Union*: Theta(N), Theta(N), Theta(1) 
- *Weighted Quick Union (WQU)*: Theta(N), O(N), O(N) 
- *WQU with Path Compression*: Theta(N), O(log N), O(log) 

*We will see how design decisions greatly affect asymptotic runtime and code complexity*

When you are trying to implement some high-level data structure using basic building 
blocks, the choice of the building blocks that you use, your instance variables, 
will deeply affect the complexity of your code and its performance in ways that are just
so important. 

The lesson to take away is that initial design decisions determine our code 
complexity and runtime. 
