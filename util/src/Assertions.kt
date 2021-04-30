package graph.util

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.junit.Assert

object Assertions {
    fun assertPersonVertexEdgeCount(g: GraphTraversalSource, firstName: String, expectedNumberOfEdges: Long) {
        val edgeCount = g.V().has("Person", "firstName", firstName).out().count().next()
        Assert.assertTrue("Expect $expectedNumberOfEdges number of edges for `Person($firstName)` vertex but found $edgeCount", edgeCount == expectedNumberOfEdges)
    }

    fun assertPersonVertexExists(g: GraphTraversalSource, firstName: String) {
        val exists = g.V().has("Person", "firstName", firstName).count().next() > 0
        Assert.assertTrue("Expect one vertex of type `Person` with `firstName` property equal to `$firstName`.", exists)
    }

    fun assertTotalNumberOfVertices(g: GraphTraversalSource, expectedVerticesCount: Long) {
        val verticesCount = g.V().count().next()
        Assert.assertEquals("Expect number of Vertices in graph.", expectedVerticesCount, verticesCount)
    }

    fun assertPersonVertexEdges(g: GraphTraversalSource, fromFirstName: String, toFirstName: String, edgeLabel: String) {
        val edgeCount = g.V().has("Person", "firstName", fromFirstName)
            .out(edgeLabel)
            .V()
            .has("Person", "firstName", toFirstName)
            .count()
            .next()
        Assert.assertTrue("Expect one edge of type `$edgeLabel` from `$fromFirstName` to `$toFirstName` but found $edgeCount.", edgeCount == 1L)
    }
}