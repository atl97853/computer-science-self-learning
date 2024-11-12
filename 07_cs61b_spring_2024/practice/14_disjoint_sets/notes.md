Goal: Design an efficient DisjointSets implementation. 
- Number of elements N can be huge. 
- Number of method calls M can be huge. 
- Calls to methods may be interspersed (e.g. can't assume it's only connect operations
followed by only isConnected operations). 

For each item, its connected component is the set of all items that are connected to 
that item. 

We will discuss four iterations of a Disjoint Sets design before being satisfied. 
Implementation, Constructor, connect(), isConnected. 
- *Quick Union*: Θ(N), O(N), O(N)
- *Quick Find*: Θ(N), Θ(N), Θ(1) 
- *Quick Union*: Θ(N), O(N), O(N)
- *Weighted Quick Union (WQU)*: Θ(N), O(log N), O(log N) 
- *WQU with Path Compression*: Θ(N), O(log N), O(log N) 

*We will see how design decisions greatly affect asymptotic runtime and code complexity*

When you are trying to implement some high-level data structure using basic building 
blocks, the choice of the building blocks that you use, your instance variables, 
will deeply affect the complexity of your code and its performance in ways that are just
so important. 

The lesson to take away is that initial design decisions determine our code 
complexity and runtime. 

Why logNlogN? The video above presents a more visual explanation. Here's an optional mathematical 
explanation why the maximum height is log2Nlog2​N. Imagine any element x in tree T1T1. The depth of x 
increases by 1 only when T1T1 is placed below another tree T2T2. When that happens, the size of the 
resulting tree will be at least double the size of T1T1 because size(T2)≥size(T1)size(T2)≥size(T1). 
The tree with x can double at most log2Nlog2​N times until we've reached a total of N items (2log2N=N2log2​N=N). 
So we can double up to log2Nlog2​N​​ times and each time, our tree adds a level → maximum log2Nlog2​N levels. 

14.5 Weighted Quick Union with Path Compression: 
https://www.youtube.com/watch?v=DZKzDebT4gU 

