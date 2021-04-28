# Limiting path in recursion

For a large graph, there can be thousands of paths connecting two vertices.
Some of them may be short and others very long.
When writing a graph search, it is worth adding a constraint, e.g. do not search for paths longer than `n`.

Add a condition that will allow limiting the length of returned paths based on the function argument.
