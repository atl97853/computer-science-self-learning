# Reading 4: Code Review 

In today's class, we will practice: 
- **code review:** reading and discussing code written by somebody else 
- **general principles of good coding:** things you can look for in every code review, regardless of programming language or program purpose

## Code review 
Code review really has two purposes: 
- **Improving the code.** Finding bugs, anticipating possible bugs, checking the clarity of the code, and checking for consistency with the project's style standards. 
- **Improving the programmer.** Code review is an important way that programmers learn and teach each other, about new language features, changes in the design of the project or its coding standards, and new techniques. In open source projects, particularly, much conversation happens in the context of code reviews.

Code review is also widely practiced in industry. 
<a href="https://google.github.io/eng-practices/review/">Google's code review process</a>

### Style standards
It’s important to be self-consistent, however, and it’s very important to follow the conventions of the project you’re working on.

The rest of this reading talks about some of these rules, at least the ones that are relevant at this point in the course, where we're mostly talking about writing basic Java. **These are some things you should start to look for when you're code reviewing other people's code, and when you're looking at your own code for improvement.**

## Smelly example #1
