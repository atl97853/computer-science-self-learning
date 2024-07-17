# 2.3 Git Basics - Viewing the Commit History

`git log`: After you have created several commits, or if you have cloned a repository with an existing commit history, you’ll probably want to look back to see what has happened. It lists the commits made in that repository in reverse chronological order, the author’s name and email, the date written, and the commit message.

`-p `



`git log --oneline -- path/to/file`: very useful filter. 

`git shortlog | grep -E '^[ ]+\w+' | wc -l `: total number of commits in a repo.

`git shortlog` 

`git log "name of the file"`: See only the commits that modified that file.

`git log --name-status`: You can see how many files were added, how many times an existing file has been modified, how many times has a file been deleted. 
- *A* means a file was added. 
- *B* means a file was modified. 
- *C* means a file was deleted. 

`git log -p` and `git log -p "name of the file"`: It will show the history of the file including diffs, so that's how you can see the original contents of the file and what its changes. 

`git log --oneline --graph`: Graphical representation of the history of the repository. Git tools will often show you logs where commits might be out of order unless you ask them to list commits in-order bu date. 

`git revert`: Revert some existing commits. Given one or more existing commits, revert the changes that the related patches introduce, and record some new commits that record them. This requires your working tree to be clean (no modifications from the HEAD commit).

“Untracked changes”: a new file that has never been committed. 