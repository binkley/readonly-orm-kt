package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.FooIdFormatter.Companion.fooId
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

internal class FooIdFormatterTest {
    @Test
    fun shouldFormat() {
        assertThat(fooId(AInputRecord("FUBAR lives!")),
                `is`("FUBAR lives!"))
    }
}
