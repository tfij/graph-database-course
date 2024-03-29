import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.`__` as underscore

fun updateGraph(g: GraphTraversalSource) {
    g.V().has("Person", "firstName", "Dave")
        .property("lastName", "Dacota")
        .iterate()

    g.V().has("Person", "firstName", "Margareth")
        .outE("fan")
        .where(underscore.otherV().has("Person", "firstName", "Adel"))
        .property("since", 2017)
        .iterate()
}
