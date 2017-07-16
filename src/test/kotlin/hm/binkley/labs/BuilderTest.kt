package hm.binkley.labs

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.b.BOutputRecord.Companion
import org.hamcrest.Matchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.mockito.Mockito.*
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

        build(results, file, ::AInputRecord, Companion::asBOutputRecord) {
            it.joinToString("|")
        }

        verify(results, times(1)).close()

        assertThat(file.readLines(), `is`(listOf(
                "A|Bar marker?|3|3 × A|",
                "B|Bar marker?|4|4 × B|")))
    }
}
