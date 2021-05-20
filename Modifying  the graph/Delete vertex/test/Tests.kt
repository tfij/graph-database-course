import graph.util.Assertions
import graph.util.InitGraphDataUtil
import org.junit.Test

class Test {
    @Test
    fun testSolution() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphModifyingLessonGraph(g)

        // when I call task function
        deleteMargarethVertex(g)

        // then function returns valid data set
        Assertions.assertTotalNumberOfVertices(g, 3)
        Assertions.assertPersonVertexExists(g, "Bil")
        Assertions.assertPersonVertexExists(g, "Adel")
        Assertions.assertPersonVertexExists(g, "Dave")
        Assertions.assertPersonVertexEdges(g, "Bil", "Adel", "fan")
        Assertions.assertPersonVertexEdges(g, "Dave", "Adel", "fan")
        Assertions.assertPersonVertexEdgeCount(g, "Bil", 1)
        Assertions.assertPersonVertexEdgeCount(g, "Adel", 0)
        Assertions.assertPersonVertexEdgeCount(g, "Dave", 1)
    }
}