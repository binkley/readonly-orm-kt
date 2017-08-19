package hm.binkley.labs

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.sql.ResultSet

internal class ResultSetIteratorTest {
    @Test(expected = NoSuchElementException::class)
    fun shouldComplainIfNotBegun() {
        val results = mock(ResultSet::class.java)
        `when`(results.isBeforeFirst).thenReturn(true)

        ResultSetIterator(results).next()
    }

    @Test(expected = NoSuchElementException::class)
    fun shouldComplainIfExhausted() {
        val results = mock(ResultSet::class.java)
        `when`(results.isAfterLast).thenReturn(true)

        ResultSetIterator(results).next()
    }
}
