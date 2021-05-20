import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.`__` as underscore

fun deleteEdges(g: GraphTraversalSource) {
    g.V().has("Person", "firstName", "Dave")
        .outE("fan")
        .where(underscore.otherV().has("Person", "firstName", "Adel"))
        .drop()
        .iterate()
}
