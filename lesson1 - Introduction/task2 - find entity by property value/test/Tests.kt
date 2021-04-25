import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph
import org.junit.Assert
import org.junit.Test

class Test {
    private fun g(): GraphTraversalSource {
        return AnonymousTraversalSource.traversal().withEmbedded(TinkerGraph.open())
    }

    private fun initGraphWithSampleData(g: GraphTraversalSource) {
        val john = g.addV("Person").property("firstName", "John").next()
        val dave = g.addV("Person").property("firstName", "Dave").next()
        val mark = g.addV("Person").property("firstName", "Mark").next()
    }

    @Test
    fun testSolution() {
        // given graph with sample data
        val g = g()
        initGraphWithSampleData(g)

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