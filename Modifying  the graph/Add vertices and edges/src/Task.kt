import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource

fun completeGraph(g: GraphTraversalSource) {
    g.addV("Person").property("firstName", "Jenefer").next()
    g.addV("Person").property("firstName", "John").next()
    addEdge(g, "Adel", "Margareth", "friendOf")
    addEdge(g, "Jenefer", "Dave", "friendOf")
    addEdge(g, "John", "Jenefer", "friendOf")
}

private fun addEdge(g: GraphTraversalSource, from: String, to: String, edgeLabel: String) {
    g.V().has("Person", "firstName", to).`as`("a")
        .V().has("Person", "firstName", from)
        .addE(edgeLabel).to("a")
        .next()
}