import graph.util.Assertions
import graph.util.InitGraphDataUtil
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.deleteEdgeTaskGraph(g)

        // when I call task function
        deleteEdges(g)

        // then function returns valid data set
        Assertions.assertTotalNumberOfVertices(g, 4)
        Assertions.assertPersonVertexExists(g, "Bil")
        Assertions.assertPersonVertexExists(g, "Adel")
        Assertions.assertPersonVertexExists(g, "Dave")
        Assertions.assertPersonVertexExists(g, "Margareth")
        Assertions.assertPersonVertexEdges(g, "Bil", "Adel", "fan")
        Assertions.assertPersonVertexEdges(g, "Dave", "Margareth", "friendOf")
        Assertions.assertPersonVertexEdges(g, "Dave", "Bil", "fan")
        Assertions.assertPersonVertexEdges(g, "Margareth", "Adel", "fan")
        Assertions.assertPersonVertexEdgeCount(g, "Bil", 1)
        Assertions.assertPersonVertexEdgeCount(g, "Adel", 0)
        Assertions.assertPersonVertexEdgeCount(g, "Dave", 2)
        Assertions.assertPersonVertexEdgeCount(g, "Margareth", 1)
    }
}