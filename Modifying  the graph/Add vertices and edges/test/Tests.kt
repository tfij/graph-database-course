import graph.util.Assertions.assertPersonVertexEdgeCount
import graph.util.Assertions.assertPersonVertexEdges
import graph.util.Assertions.assertPersonVertexExists
import graph.util.Assertions.assertTotalNumberOfVertices
import graph.util.InitGraphDataUtil
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
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
}