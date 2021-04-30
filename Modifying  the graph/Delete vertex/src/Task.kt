import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun deleteMargarethVertex(g: GraphTraversalSource) {
    g.V().has("Person", "firstName", "Margareth")
        .drop()
        .iterate()
}