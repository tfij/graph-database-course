import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun findByFirstName(g: GraphTraversalSource, firstName: String): Map<Any, Any> {
    return g.V().has("firstName", firstName).valueMap<Any>().next()
}
