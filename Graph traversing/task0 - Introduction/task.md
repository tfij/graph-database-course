# Introduction to traversing

Graph databases work best when there are many dependencies and relationships between the data.
Therefore, the edges in the graph databases are the first class citizens.

Let's expand our graph with a few more objects and add relations between them.
The diagram below shows the graph we will work on in this lesson.

![Data graph](../resources/dataGraph.png)

More persons and two relation types `friendOf` and `fan` have been added to the graph.

All edges have to have a direction.
In the case of a `friendOf`, one direction of relation is not natural, friendship is rather bidirectional.
In such a situation, when modeling the graph, the direction of the relation does not matter.
You should remember about that when traversing.

Click `Next` to go to the next task.
