package hm.binkley.labs.a

import org.hamcrest.Matchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.eq
import org.mockito.Mockito.mock
import java.sql.ResultSet

internal class AInputRecordTest {
    @Test fun shouldConstruct() {
        val results = mock(ResultSet::class.java)
        `when`(results.getString(eq("fooId"))).thenReturn("FUBAR lives!")
        `when`(results.getInt(eq("bazCount"))).thenReturn(3)

        assertThat(AInputRecord(results), `is`(AInputRecord("FUBAR lives!", 3)))
    }
}
