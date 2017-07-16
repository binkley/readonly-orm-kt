package hm.binkley.labs.field

import hm.binkley.labs.input.InputRecord
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

abstract class FormatterTestBase<I, T>(
        private val record: I,
        private val format: (I) -> T,
        private val expected: T)
where I : InputRecord {
    @Test
    fun shouldFormat() {
        assertThat(format(record), `is`(expected))
    }
}
