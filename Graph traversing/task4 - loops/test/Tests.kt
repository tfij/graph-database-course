import graph.util.InitGraphDataUtil
import org.junit.Assert
import org.junit.Test

class Test {

    @Test
    fun testSolutionForDeep2() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphTraversingLessonGraph(g)

        // and firstName = Dave
        val firstName = "Mark"

        // when I call task function
        val allEntities = allDeepFriends(g, firstName, 2)

        // then function returns valid data set
        Assert.assertEquals(
            "Find all %s friends in deep 2".format(firstName),
            setOf("John", "Dave", "Margareth", firstName).sorted(),
            allEntities.sorted()
        )
    }

    @Test
    fun testSolutionForDeep3() {
        // given graph with sample data
        val g = InitGraphDataUtil.g()
        InitGraphDataUtil.graphTraversingLessonGraph(g)

        // and firstName = Dave
        val firstName = "Adel"

        // when I call task function
        val allEntities = allDeepFriends(g, firstName, 3)

        // then function returns valid data set
        Assert.assertEquals(
            "Find all %s friends in deep 3".format(firstName),
            setOf("John", "Dave", "Margareth", "Mark", "Jenefer").sorted(),
            allEntities.sorted()
        )
    }
}
