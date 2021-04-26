import graph.util.InitGraphDataUtil
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolution() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.introductionLessonGraph(g)

        // and firstName = Dave
        val firstName = "Dave"

        // when I call task function
        val allEntities = findByFirstName(g, firstName)

        // then function returns valid data set
        Assert.assertEquals(
            "Find %s entity".format(firstName),
            mapOf("firstName" to listOf(firstName)),
            allEntities
        )
    }
}