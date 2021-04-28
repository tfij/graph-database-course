import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun count(g: GraphTraversalSource): Long {
    return g.V().count().next()
}

fun main() {
    println("Read the introduction and click \"Next\" and go to your first task.")
}
