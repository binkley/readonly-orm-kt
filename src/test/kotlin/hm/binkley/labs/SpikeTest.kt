package hm.binkley.labs

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.a.AOutputRecord
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.eq
import org.mockito.Mockito.mock
import java.sql.ResultSet

class SpikeTest {
    @Test
    fun xxx() {
        val results = mock(ResultSet::class.java)
        `when`(results.next()).
                thenReturn(true, true, false)
        `when`(results.getString(eq("fooId"))).
                thenReturn("A", "B")
        `when`(results.getInt(eq("bazCount"))).
                thenReturn(3, 4)

        ResultSetIterator(results).asSequence().
                map(::AInputRecord).
                map(::AOutputRecord).
                map { it.fields() }.
                map { it.joinToString("|") }.
                forEach { println(it) }
    }

    class ResultSetIterator(
            private val results: ResultSet) : Iterator<ResultSet> {
        override fun hasNext() = results.next()

        override fun next() = results
    }
}
