import org.apache.tinkerpop.gremlin.process.traversal.P
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.`__` as underscore

fun findPath(g: GraphTraversalSource, fromFirstName: String, toFirstName: String, maxPathLength: Int): List<List<String>> {
    return g.V()
        .has("firstName", fromFirstName)
        .repeat(
            underscore.both("friendOf").simplePath()
        )
        .until(underscore.and<Any>(
            underscore.has<String>("firstName", toFirstName),
            underscore.loops<Int>().`is`(P.lt(maxPathLength))
        ))
        .path().by("firstName")
        .toList()
        .map { path -> path.map { it.toString() } }
}
