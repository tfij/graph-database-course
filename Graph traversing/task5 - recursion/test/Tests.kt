import graph.util.InitGraphDataUtil
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolutionFromJohnToMargareth() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphTraversingLessonGraph(g)

        // and firstName = Dave
        val from = "John"
        val to = "Margareth"

        // when I call task function
        val allEntities = findPath(g, from, to)

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
}
