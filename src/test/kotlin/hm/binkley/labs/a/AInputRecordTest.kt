package hm.binkley.labs.a

import hm.binkley.labs.input.HasBazCount.Companion.bazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.HasFooId.Companion.fooId
import org.hamcrest.Matchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.eq
import org.mockito.Mockito.mock
import java.sql.ResultSet

internal class AInputRecordTest {
    @Test
    fun shouldConstruct() {
        val results = mock(ResultSet::class.java)
        `when`(results.getString(eq(HasFooId.COLUMN))).thenReturn(
                "FUBAR lives!")
        `when`(results.getInt(eq("bazCount"))).thenReturn(3)

        assertThat(AInputRecord(results),
                `is`(AInputRecord(fooId("FUBAR lives!"), bazCount(3))))
    }
}
