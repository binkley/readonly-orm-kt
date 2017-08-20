package hm.binkley.labs.field.output

import hm.binkley.labs.field.FieldFactory.Field
import hm.binkley.labs.input.InputRecord
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

abstract class FormatterTestBase<I, T, F : Field<T, F, *>>(
        private val record: I,
        private val format: (I) -> F,
        private val expected: T)
        where I : InputRecord {
    @Test
    fun shouldFormat() {
        assertThat(format(record).value, `is`(expected))
    }
}
