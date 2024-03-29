import graph.util.InitGraphDataUtil
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolution() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphTraversingLessonGraph(g)

        // and firstName = Dave
        val firstName = "Dave"

        // when I call task function
        val allEntities = allFriendsOf(g, firstName)

        // then function returns valid data set
        Assert.assertEquals(
            "Find all %s friends".format(firstName),
            listOf("Margareth", "Jenefer").sorted(),
            allEntities.sorted()
        )
    }
}
