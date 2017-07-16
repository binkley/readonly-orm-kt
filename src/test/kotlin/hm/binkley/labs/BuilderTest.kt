package hm.binkley.labs

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.b.BOutputRecord.Companion
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import org.hamcrest.Matchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.mockito.Mockito.`when`
import org.mockito.Mockito.eq
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import java.io.File
import java.sql.ResultSet

class BuilderTest {
    @Rule @JvmField
    val tmpdir = TemporaryFolder()

    @Test
    fun shouldBuild() {
        val results = mock(ResultSet::class.java)
        `when`(results.next()).
                thenReturn(true, true, false)
        `when`(results.getString(eq("fooId"))).
                thenReturn("A", "B")
        `when`(results.getInt(eq("bazCount"))).
                thenReturn(3, 4)

        val file = tmpdir.newFile()

        build(results, ::AInputRecord, Companion::asBOutputRecord, file)

        verify(results, times(1)).close()

        assertThat(file.readLines(), `is`(listOf(
                "A|Bar marker?|3|3 × A",
                "B|Bar marker?|4|4 × B")))
    }

    private fun <I : InputRecord, O : OutputRecord> build(
            results: ResultSet,
            toInputRecord: (ResultSet) -> I,
            toOutputRecord: (I) -> O,
            file: File) {
        results.use { input ->
            file.printWriter().use { output ->
                ResultSetIterator(input).asSequence().
                        map(toInputRecord).
                        map(toOutputRecord).
                        map { it.fields() }.
                        map { it.joinToString("|") }.
                        forEach { output.println(it) }
            }
        }
    }

    private class ResultSetIterator(
            private val results: ResultSet) : Iterator<ResultSet> {
        override fun hasNext() = results.next()

        override fun next() = results
    }
}
