import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun count(g: GraphTraversalSource): Long {
    return g.V().count().next()
}

// Read the introduction and click "Check" and go to your first task.