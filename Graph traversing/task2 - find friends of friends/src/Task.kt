import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun allFriendsOfFriendsOf(g: GraphTraversalSource, firstName: String): Set<String> {
    return g.V()
        .has("firstName", firstName)
        .both("friendOf")
        .both("friendOf")
        .values<String>("firstName")
        .toSet()
}
