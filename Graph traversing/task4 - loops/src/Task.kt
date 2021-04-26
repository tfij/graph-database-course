import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.`__` as it

fun allDeepFriends(g: GraphTraversalSource, firstName: String, deep: Int): List<String> {
    return g.V()
        .has("firstName", firstName)
        .repeat(
            it.both("friendOf")
        )
        .times(deep)
        .dedup()
        .values<String>("firstName")
        .toList()
}
