import graph.util.InitGraphDataUtil
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testSolutionFromJohnToMargarethWithDeep5() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphModifyingLessonGraph(g)

        // when I call task function
        completeGraph(g)

        // then function returns valid data set
        assertPersonVertexExists(g, "Bil")
        assertPersonVertexExists(g, "Adel")
        assertPersonVertexExists(g, "Dave")
        assertPersonVertexExists(g, "Jenefer")
        assertPersonVertexExists(g, "John")
        assertPersonVertexExists(g, "Margareth")
        assertTotalNumberOfVertices(g, 6)
        assertPersonVertexEdges(g, "Bil", "Adel", "fan")
        assertPersonVertexEdges(g, "Dave", "Adel", "fan")
        assertPersonVertexEdges(g, "Dave", "Margareth", "friendOf")
        assertPersonVertexEdges(g, "Adel", "Margareth", "friendOf")
        assertPersonVertexEdges(g, "Margareth", "Adel", "fan")
        assertPersonVertexEdges(g, "Jenefer", "Dave", "friendOf")
        assertPersonVertexEdges(g, "John", "Jenefer", "friendOf")
        assertPersonVertexEdgeCount(g, "Bil", 1)
        assertPersonVertexEdgeCount(g, "Adel", 1)
        assertPersonVertexEdgeCount(g, "Dave", 2)
        assertPersonVertexEdgeCount(g, "Jenefer", 1)
        assertPersonVertexEdgeCount(g, "John", 1)
        assertPersonVertexEdgeCount(g, "Margareth", 1)
    }

    private fun assertPersonVertexEdgeCount(g: GraphTraversalSource, firstName: String, expectedNumberOfEdges: Long) {
        val edgeCount = g.V().has("Person", "firstName", firstName).out().count().next()
        Assert.assertTrue("Expect $expectedNumberOfEdges number of edges for `Person($firstName)` vertex but found $edgeCount", edgeCount == expectedNumberOfEdges)
    }

    private fun assertPersonVertexExists(g: GraphTraversalSource, firstName: String) {
        val exists = g.V().has("Person", "firstName", firstName).count().next() > 0
        Assert.assertTrue("Expect one vertex of type `Person` with `firstName` property equal to `$firstName`.", exists)
    }

    private fun assertTotalNumberOfVertices(g: GraphTraversalSource, expectedVerticesCount: Long) {
        val verticesCount = g.V().count().next()
        Assert.assertEquals("Expect number of Vertices in graph.", expectedVerticesCount, verticesCount)
    }

    private fun assertPersonVertexEdges(g: GraphTraversalSource, fromFirstName: String, toFirstName: String, edgeLabel: String) {
        val edgeCount = g.V().has("Person", "firstName", fromFirstName)
            .out(edgeLabel)
            .V()
            .has("Person", "firstName", toFirstName)
            .count()
            .next()
        Assert.assertTrue("Expect one edge of type `$edgeLabel` from `$fromFirstName` to `$toFirstName` but found $edgeCount.", edgeCount == 1L)
    }
}