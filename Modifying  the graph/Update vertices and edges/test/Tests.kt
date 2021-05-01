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
        updateGraph(g)

        // then function returns valid data set
        Assertions.assertPersonVertexExists(g, "Bil")
        Assertions.assertPersonVertexExists(g, "Adel")
        Assertions.assertPersonVertexExists(g, "Dave", "Dacota")
        Assertions.assertPersonVertexExists(g, "Margareth")
        Assertions.assertTotalNumberOfVertices(g, 4)
        Assertions.assertPersonVertexEdges(g, "Bil", "Adel", "fan")
        Assertions.assertPersonVertexEdges(g, "Dave", "Margareth", "friendOf")
        Assertions.assertPersonVertexEdges(g, "Margareth", "Adel", "fan", 2017)
        Assertions.assertPersonVertexEdgeCount(g, "Bil", 1)
        Assertions.assertPersonVertexEdgeCount(g, "Adel", 0)
        Assertions.assertPersonVertexEdgeCount(g, "Dave", 2)
        Assertions.assertPersonVertexEdgeCount(g, "Margareth", 1)
    }
}
