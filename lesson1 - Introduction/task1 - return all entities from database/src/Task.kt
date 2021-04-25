import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun findAll(g: GraphTraversalSource): List<Map<Any, Any>> {
    return g.V().valueMap<Any>().toList()
}
