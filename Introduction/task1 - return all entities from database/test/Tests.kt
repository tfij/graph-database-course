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

        // when I call task function
        val allEntities = findAll(g)

        // then function returns valid data set
        Assert.assertEquals(
            "findAll returns all entities",
            listOf(
                mapOf("firstName" to listOf("John")),
                mapOf("firstName" to listOf("Dave")),
                mapOf("firstName" to listOf("Mark"))
            ),
            allEntities
        )
    }
}