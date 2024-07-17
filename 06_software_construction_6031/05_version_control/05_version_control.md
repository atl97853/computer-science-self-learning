# Reading 5: Version Control 

### Objectives:
- Know what version control is and why we use it
- Understand how Git stores version history as a graph
- Practice reading, creating, and using version history

## Introduction 
Version control: 
- It's the software engineering practice of controlling computer files and versions of files; primarily source code text files, but generally any type of file.

Version control system: 
- It's a software tool that automates version control. Alternatively, version control is embedded as a feature of some systems such as word processors, spreadsheets, collaborative web docs, and content management systems

Version control systems are essential tools of the software engineering world. More or less every project — serious or hobby, open source or proprietary — uses version control.

## Inventing version control

standard software tools for comparing text; in the UNIX world, one such tool is diff. A better version control system will make diffs easy to generate.

At this point, considering just the scenario of one programmer working alone, we already have a list of operations that should be supported by a version control scheme:

- reverting to a past version
- comparing two different versions
- pushing full version history to another location
- pulling history back from that location
- merging versions that are offshoots of the same earlier version

### Multiple developers 

The two programmers must coordinate on a scheme for coming up with version numbers. Ideally, the scheme allows us to assign clear names to whole sets of files, not just individual files. 
- (Files depend on other files, so thinking about them in isolation allows inconsistencies.)

### Multiple branches

### The shocking conclusion 
Of course, it turns out we haven’t invented anything here: Git does all these things for you, and so do many other version control systems.
- Git is a free and open source distributed version control system

### Distributed vs. centralized


### Version control terminology 

### Features of a version control system 

## Git 

### Getting started with Git
### The Git object graph

### 1.3 Getting Started - What is Git? 

Git thinks of its data more like a series of snapshots of a miniature filesystem.

- Git basically takes a picture of what all your files look like at that moment and stores a reference to that snapshot. 
- To be efficient, if files have not changed, Git doesn’t store the file again, just a link to the previous identical file it has already stored.
- Git thinks about its data more like a **stream of snapshots.**
- This is an important distinction between Git and nearly all other VCSs.

**Nearly Every Operation Is Local**

Most operations in Git need only local files and resources to operate — generally no information is needed from another computer on your network

Because you have the entire history of the project right there on your local disk, most operations seem almost instantaneous.

**For example:**
- To browse the history of the project, Git doesn’t need to go out to the server to get the history and display it for you — it simply reads it directly from your local database.
- If you want to see the changes introduced between the current version of a file and the file a month ago, Git can look up the file a month ago and do a local difference calculation, instead of having to either ask a remote server to do it or pull an older version of the file from the remote server to do it locally.
- This also means that there is very little you can’t do if you’re offline or off VPN. If you get on an airplane or a train and want to do a little work, you can commit happily:
  - (to your local copy, remember?) until you get to a network connection to upload.

**Git Has Integrity**

Everything in Git is checksummed before it is stored and is then referred to by that checksum.
- This means it’s impossible to change the contents of any file or directory without Git knowing about it.
- You can’t lose information in transit or get file corruption without Git being able to detect it.

***The mechanism that Git uses for this checksumming is called a SHA-1 hash.*** This is a 40-character string composed of hexadecimal characters (0–9 and a–f) and calculated based on the contents of a file or directory structure in Git. A SHA-1 hash looks something like this:
- `24b9da6552252987aa493b52f8696cd6d3b00373`

You will see these hash values all over the place in Git because it uses them so much. In fact, Git stores everything in its database not by file name but by the hash value of its contents.

**Git Generally Only Adds Data**

When you do actions in Git, nearly all of them only add data to the Git database. It is hard to get the system to do anything that is not undoable or to make it erase data in any way.
- We can experiment without the danger of severely screwing things up. 

**The Three States**

***Pay attention now — here is the main thing to remember about Git if you want the rest of your learning process to go smoothly.***

***Git has three main states that your files can reside in***
- ***Modified.*** Modified means that you have changed the file but have not commited it to your database yet. 
- ***Staged.*** Staged means that you have marked a modified file in its current version to go into your next commit snapshot. 
- ***Committed.*** Commited means that the data is safely stored in your local database. 

***This leads us to the three main sections of a Git project:***
- The working tree 
- The staging area 
- The Git directory

(Git)

**The working tree** is a single checkout of one version of the project. These files are pulled out of the compressed database in the Git directory and placed on disk for you to use or modify.
- In simpler terms, think of the working tree as your desk where you're actively working on your project files. Git, on the other hand, is like a filing cabinet that stores different versions of your project (like snapshots of your messy desk at different points in time).
- So, the working tree is more like a dynamic workspace where you interact with the current state of your project files, while the Git repository acts like a central storage for all the versions and history.
- 
**The staging area** is a file, generally contained in your Git directory, that stores information about ***what will go into your next commit.*** Its technical name in Git parlance is the “index”, but the phrase “staging area” works just as well.
- The staging area in Git, also sometimes called the index, acts as an intermediary zone between your working tree and the Git repository. It's like a staging area for a play before the final performance (the commit).

**The Git directory** is where Git stores the metadata and object database for your project. This is ***the most important part of Git***, and ***it is what is copied when you clone a repository from another computer.***


**Here's a breakdown of the three sections and their roles:** (Gemini)

- **Working Tree:** This is the directory containing your current project files that you actively work on. It represents the ever-changing state of your project.
- **Staging Area (Index):** This acts as a temporary holding area for changes you plan to include in your next commit. You choose which specific changes from your working tree to "stage" here.
- **Git Directory (.git directory):** This hidden folder is the heart of the Git system. It stores the project's version history, including:
  - Commits: Snapshots of your project state at specific points in time.
  - Branches: Different development paths you can work on simultaneously.
  - References to different versions of files: This allows Git to track changes efficiently without storing duplicate copies of entire files.
  - 
So, while "the Git directory" might be used loosely to refer to the entire repository in everyday conversation, technically it refers to the specific hidden folder (.git) that manages the project's historical data.

**The basic Git workflow goes something like this:**
- You modify files in your working tree.
- You selectively stage just those changes you want to be part of your next commit, which adds only those changes to the staging area.
- You do a commit, which takes the files as they are in the staging area and stores that snapshot permanently to your Git directory.


**When you run git commit, the following happens:**
- The staged changes are captured: The specific versions of files you added to the staging area are taken as a snapshot.
- The commit object is created: This object stores the snapshot of the staged files, along with your commit message.
- The commit object is stored in the Git directory: This permanent record of the project state becomes part of the Git repository's history, residing within the .git folder.

## Copy an object graph with git clone

**The object graph** is stored on disk in a convenient and efficient structure for performing Git operations, but not in a format we can easily use.

In Git, we obtain normal copies of our files by checking them out from the object graph.

**The history graph** is the backbone of the full object graph stored in .git, so let’s focus on it for a minute.

Each commit is identified by a unique ID, displayed as a hexadecimal number.

Except for the initial commit, each commit has a pointer to a parent commit. For example, commit 1255f4e has parent 41c4b8f: this means 41c4b8f happened first, then 1255f4e.

Some commits have the same parent. They are versions that diverged from a common previous version, for example because two developers were working independently.

And a commit can have two parents. This is a version that ties divergent histories back together, for example because those developers then merged their work together again.

The HEAD commit is indeed the last commit made on the currently checked-out branch.

Here's a quick recap:

HEAD is a pointer to the latest commit in the active branch.
When you make a new commit, HEAD moves to point to that new commit, making it the latest.
So, the HEAD commit is always the most recent commit in your current branch's history.

**What would be the meaning of a cycle in the history graph?**

- Some commit is its own ancestor 
- Some commit is a descendant of itself 
- This is impossible 

**The history graph is acyclic.** If commit A is the parent of commit B, or in general reachable by traversing directed parent edges from commit B, it means commit A existed before commit B. 

If at the same time commit B is reachable by traversing directed parent edges from commit A, then commit B existed before commit A.
 
Both of these conditions cannot be satisfied simultaneously. 

## What else is in the object graph? 

***When you commit, you're essentially creating a snapshot of your staged changes and storing that snapshot in the Git directory.***

Here's a quick breakdown:

- Staging area: Prepares the changes for the commit.
- Commit: Creates a permanent record of the staged changes in the Git directory.

the Git object graph stores each version of an individual file once, and allows multiple commits to share that one copy.

## Add to the object graph with `git commit`

How do we add new commits to the history graph?
- git commit creates a new commit.

The staging area is like a proto-commit, a commit-in-progress. 

Here’s how we use the staging area and git add to build up a new snapshot, which we then cast in stone using git commit:
- If we haven’t made any changes yet, then the working directory, staging area, and HEAD commit are all identical.
- Make a change to a file. For example, let’s edit hello.txt.
Other changes might be creating a new file, or deleting a file.
- Stage those changes using git add.
- Create a new commit out of all the staged changes using git commit.

***Use git status frequently*** to keep track of whether you have no changes, unstaged changes, or staged changes; and whether you have new commits in your local repository that haven’t been pushed.

## Reading Exercises

The Java compiler compiles .java files into .class files. 
<br>Should you commit .class files to version control?
- no
- 99% of the time, you should only commit your source files to version control, not their compiled binaries. Binaries aren’t human-readable (ETU) or -editable (RFC). If we keep them in the repo and they get out of sync with the source files, debugging the problem will be maddening because the running program doesn’t correspond to the source code! (SFB)
- Git uses hidden files called .gitignore to specify files or directories that should be ignored by version control.

Can we have both staged and unstaged changes at the same time?
- yes 
- Easy way: change two files, but only git add one of them. git status shows one file as staged, and the other file as still unstaged.
- Tricky way: change one file, git add to stage it, and then make a further change to the same file. The first change is now staged, but the second change is still unstaged. git status shows the file as both staged and unstaged, which is confusing unless you realize that it refers to different changes made to the same file.

After the commit, can there still be changes that are staged?
- no 
- git commit turns all staged changes into a commit, so there cannot be any remaining staged changes…

Can there still be changes that are unstaged?
- yes 
- … but it does nothing to unstaged changes, so if there were unstaged changes before, they will still be there.

**“Untracked changes”: a new file that has never been committed.**

### Sequences, trees, and graphs

When multiple commits share the same parent commit, our history DAG changes from a sequence to a tree: it branches apart. Notice that a branch in the history of the project doesn’t require anyone to create a new Git branch, merely that we start from the same commit and work in parallel on different copies of the repository.

The history DAG changes from tree- to graph-shaped when the branching changes are merged together.

How is it that changes are merged together? First we’ll need to understand how history is shared between different users and repositories.

## Send and receive object graphs with git push and git pull
