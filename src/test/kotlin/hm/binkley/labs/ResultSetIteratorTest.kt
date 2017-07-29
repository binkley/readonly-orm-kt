package hm.binkley.labs

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.sql.ResultSet

internal class ResultSetIteratorTest {
    @Test(expected = NoSuchElementException::class)
    fun shouldComplainIfNoNext() {
        val results = mock(ResultSet::class.java)
        `when`(results.isBeforeFirst).thenReturn(true)
        `when`(results.isAfterLast).thenReturn(true)

        ResultSetIterator(results).next()
    }
}
