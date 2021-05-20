package graph.util

import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph

object InitGraphDataUtil {
    fun g(): GraphTraversalSource {
        return AnonymousTraversalSource.traversal().withEmbedded(TinkerGraph.open())
    }

    fun introductionLessonGraph(g: GraphTraversalSource) {
        val john = g.addV("Person").property("firstName", "John").next()
        val dave = g.addV("Person").property("firstName", "Dave").next()
        val mark = g.addV("Person").property("firstName", "Mark").next()
    }

    fun graphTraversingLessonGraph(g: GraphTraversalSource) {
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

    fun graphModifyingLessonGraph(g: GraphTraversalSource) {
        val dave = g.addV("Person").property("firstName", "Dave").next()
        val adel = g.addV("Person").property("firstName", "Adel").next()
        val margareth = g.addV("Person").property("firstName", "Margareth").next()
        val bil = g.addV("Person").property("firstName", "Bil").next()
        g.addE("fan").from(dave).to(adel).next()
        g.addE("friendOf").from(dave).to(margareth).next()
        g.addE("fan").from(margareth).to(adel).next()
        g.addE("fan").from(bil).to(adel).next()
    }

    fun deleteEdgeTaskGraph(g: GraphTraversalSource) {
        val dave = g.addV("Person").property("firstName", "Dave").next()
        val adel = g.addV("Person").property("firstName", "Adel").next()
        val margareth = g.addV("Person").property("firstName", "Margareth").next()
        val bil = g.addV("Person").property("firstName", "Bil").next()
        g.addE("fan").from(dave).to(adel).next()
        g.addE("friendOf").from(dave).to(margareth).next()
        g.addE("fan").from(margareth).to(adel).next()
        g.addE("fan").from(bil).to(adel).next()
        g.addE("fan").from(dave).to(bil).next()
    }

}
