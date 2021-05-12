# Find friends of friends

Write a code that returns all friends' names (`firstName` property) of friends of the person by given the first name.

Note that, by definition, the start vertex is also one of the end vertices querying friends of friends.

To remove duplicates you can use the dedup method.

After traversing to the vertex (by using the out method for example) you can traverse deeper by using another method (like both, in, out, etc).

## The graph diagram for this task
![Data graph](../resources/dataGraph.png)
