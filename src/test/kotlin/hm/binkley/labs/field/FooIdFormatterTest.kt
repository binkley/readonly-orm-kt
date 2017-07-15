package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

internal class FooIdFormatterTest {
    @Test
    fun shouldFormat() {
        assertThat(FooIdFormatter<AInputRecord>().format(
                AInputRecord("FUBAR lives!")),
                `is`("FUBAR lives!"))
    }
}
