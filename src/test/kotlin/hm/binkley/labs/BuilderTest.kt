package hm.binkley.labs

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.b.BOutputRecord.Companion
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.eq
import org.mockito.Mockito.mock
import java.sql.ResultSet

class BuilderTest {
    @Test
    fun shouldBuild() {
        val results = mock(ResultSet::class.java)
        `when`(results.next()).
                thenReturn(true, true, false)
        `when`(results.getString(eq("fooId"))).
                thenReturn("A", "B")
        `when`(results.getInt(eq("bazCount"))).
                thenReturn(3, 4)

        build(results, ::AInputRecord, Companion::asBOutputRecord) {
            println(it.joinToString("|"))
        }
    }

    private fun <I : InputRecord, O : OutputRecord> build(
            results: ResultSet,
            toInputRecord: (ResultSet) -> I,
            toOutputRecord: (I) -> O,
            action: (List<*>) -> Unit) {
        ResultSetIterator(results).asSequence().
                map(toInputRecord).
                map(toOutputRecord).
                map { it.fields() }.
                forEach(action)
    }

    private class ResultSetIterator(
            private val results: ResultSet) : Iterator<ResultSet> {
        override fun hasNext() = results.next()

        override fun next() = results
    }
}
