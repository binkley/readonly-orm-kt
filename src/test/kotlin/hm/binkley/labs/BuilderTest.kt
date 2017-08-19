package hm.binkley.labs

import hm.binkley.labs.field.BazCountFieldFactory
import hm.binkley.labs.field.FooIdFieldFactory
import hm.binkley.labs.output.OutputRecord.Field
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
import java.sql.ResultSet

class BuilderTest {
    @Rule
    @JvmField
    val tmpdir = TemporaryFolder()

    @Test
    fun shouldBuild() {
        val results = mock(ResultSet::class.java)
        `when`(results.next()).
                thenReturn(true, true, false)
        `when`(results.getString(eq(FooIdFieldFactory.COLUMN))).
                thenReturn("A", "B")
        `when`(results.getInt(eq(
                BazCountFieldFactory.COLUMN))).
                thenReturn(3, 4)

        val file = tmpdir.newFile()

        build(ABRecordFactory(), results, file) {
            it.map(Field<*>::value).joinToString("|")
        }

        verify(results, times(1)).close()

        assertThat(file.readLines(), `is`(listOf("A|Bar marker?|3|3 × A|",
                "B|Bar marker?|4|4 × B|")))
    }
}
