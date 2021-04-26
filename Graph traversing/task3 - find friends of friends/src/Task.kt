import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun allFriendsOfFriendsOf(g: GraphTraversalSource, firstName: String): List<String> {
    return g.V()
        .has("firstName", firstName)
        .both("friendOf")
        .both("friendOf")
        .dedup()
        .values<String>("firstName")
        .toList()
}
