import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.`__` as underscore

fun findPath(g: GraphTraversalSource, fromFirstName: String, toFirstName: String): List<List<String>> {
    return g.V()
        .has("firstName", fromFirstName)
        .repeat(
            underscore
                .both("friendOf")
                .simplePath()
        )
        .until(underscore.has<String>("firstName", toFirstName))
        .path().by("firstName")
        .toList()
        .map { path -> path.map { it.toString() } }
}
