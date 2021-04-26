import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun allFriendsOf(g: GraphTraversalSource, firstName: String): List<String> {
    return g.V()
        .has("firstName", firstName)
        .both("friendOf")
        .order().by("firstName")
        .values<String>("firstName")
        .toList()
}
