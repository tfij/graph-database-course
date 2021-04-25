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
        val barbara = g.addV("Person").property("firstName", "Barbara").next()
        val adel = g.addV("Person").property("firstName", "Adel").next()
        val jenefer = g.addV("Person").property("firstName", "Jenefer").next()
        val margareth = g.addV("Person").property("firstName", "Margareth").next()
        val bil = g.addV("Person").property("firstName", "Bil").next()
        g.addE("friendOf").from(mark).to(barbara).next()
        g.addE("friendOf").from(jenefer).to(mark).next()
        g.addE("friendOf").from(jenefer).to(dave).next()
        g.addE("friendOf").from(jenefer).to(margareth).next()
        g.addE("friendOf").from(john).to(jenefer).next()
        g.addE("fan").from(dave).to(adel).next()
        g.addE("friendOf").from(dave).to(margareth).next()
        g.addE("fan").from(margareth).to(adel).next()
        g.addE("friendOf").from(adel).to(margareth).next()
        g.addE("fan").from(bil).to(adel).next()
    }

    @Test
    fun testSolution() {
        // given graph with sample data
        val g = g()
        initGraphWithSampleData(g)

        // and firstName = Dave
        val firstName = "Dave"

        // when I call task function
        val allEntities = allFriendsOf(g, firstName)

        // then function returns valid data set
        Assert.assertEquals(
            "Find all %s friends".format(firstName),
            setOf("Margareth", "Jenefer"),
            allEntities
        )
    }
}
