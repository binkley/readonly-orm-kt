package hm.binkley.labs

import hm.binkley.labs.field.BazCountFieldFactory
import hm.binkley.labs.field.FooIdFieldFactory
import org.hamcrest.Matchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito.`when`
import org.mockito.Mockito.inOrder
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import java.sql.PreparedStatement
import java.sql.ResultSet

class BuilderTest {
    @Rule
    @JvmField
    val tmpdir = TemporaryFolder()

    private var fooId = with(PreparedStatement::setString, 1)
    private var barMarker = with(PreparedStatement::setString, 2)
    private var bazCount = with(PreparedStatement::setInt, 3)
    private var fooBar = with(PreparedStatement::setString, 4)
    private var quxMissing = with(PreparedStatement::setString, 5)

    @Test
    fun shouldBuild() {
        val results = mock(ResultSet::class.java)
        `when`(results.next()).
                thenReturn(true, true, false)
        `when`(results.getString(eq(FooIdFieldFactory.COLUMN))).
                thenReturn("A", "B")
        `when`(results.getInt(eq(BazCountFieldFactory.COLUMN))).
                thenReturn(3, 4)
        val insert = mock(PreparedStatement::class.java)

        val file = tmpdir.newFile()

        build(ABRecordFactory(), results, insert, file)


        fooId.verify(insert, "A", "B")
        barMarker.verify(insert, "Bar marker?", "Bar marker?")
        bazCount.verify(insert, 3, 4)
        fooBar.verify(insert, "3 × A", "4 × B")
        quxMissing.verify(insert, "", "")

        verify(results, times(1)).close()

        assertThat(file.readLines(), `is`(listOf("A|Bar marker?|3|3 × A|",
                "B|Bar marker?|4|4 × B|")))
    }

    private data class ColumnValues<T>(
            private val setter: (PreparedStatement, Int, T) -> Unit,
            private val index: Int) {
        internal fun verify(insert: PreparedStatement, first: T, second: T) {
            val inOrder = inOrder(insert)
            setter(inOrder.verify(insert, times(1)), eq(index), eq(first))
            inOrder.verify(insert, times(1)).executeUpdate()
            setter(inOrder.verify(insert, times(1)), eq(index), eq(second))
            inOrder.verify(insert, times(1)).executeUpdate()
        }
    }

    companion object {
        private fun <T> with(
                setter: (PreparedStatement, Int, T) -> Unit, index: Int)
                = ColumnValues(setter, index)
    }
}
