import graph.util.InitGraphDataUtil
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolutionFromJohnToMargarethWithDeep5() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphTraversingLessonGraph(g)

        // and
        val from = "John"
        val to = "Margareth"

        // when I call task function
        val allEntities = findPath(g, from, to ,5)

        // then function returns valid data set
        Assert.assertEquals(
            "Find path from $from to $to",
            listOf(
                listOf("John", "Jenefer", "Margareth"),
                listOf("John", "Jenefer", "Dave", "Margareth")
            ),
            allEntities
        )
    }

    @Test
    fun testSolutionFromJohnToMargarethWithDeep3() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphTraversingLessonGraph(g)

        // and
        val from = "John"
        val to = "Margareth"

        // when I call task function
        val allEntities = findPath(g, from, to ,3)

        // then function returns valid data set
        Assert.assertEquals(
            "Find path from $from to $to",
            listOf(
                listOf("John", "Jenefer", "Margareth")
            ),
            allEntities
        )
    }
}
