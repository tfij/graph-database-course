import graph.util.InitGraphDataUtil
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolution() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.introductionLessonGraph(g)

        // when I call task function
        val allEntities = findAll(g)

        // then function returns valid data set
        Assert.assertEquals(
            "findAll returns all entities",
            listOf(
                mapOf("firstName" to listOf("John")),
                mapOf("firstName" to listOf("Dave")),
                mapOf("firstName" to listOf("Mark"))
            ).sortedBy { it["firstName"]?.get(0) },
            allEntities.sortedBy { ((it["firstName"] as List<*>)[0] as String) }
        )
    }
}