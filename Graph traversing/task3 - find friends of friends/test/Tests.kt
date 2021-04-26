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
        val firstName = "Mark"

        // when I call task function
        val allEntities = allFriendsOfFriendsOf(g, firstName)

        // then function returns valid data set
        Assert.assertEquals(
            "Find all %s friends with no duplicates".format(firstName),
            allEntities.distinct().sorted(),
            allEntities.sorted()
        )
        Assert.assertEquals(
            "Find all %s friends of friends".format(firstName),
            setOf("John", "Dave", "Margareth", firstName),
            allEntities.toSet()
        )
    }
}
