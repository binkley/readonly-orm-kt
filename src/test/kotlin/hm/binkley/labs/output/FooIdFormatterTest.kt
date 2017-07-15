package hm.binkley.labs.output

import hm.binkley.labs.a.AInputRecord
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class FooIdFormatterTest {
    @Test
    fun shouldFormat() {
        assertThat(FooIdFormatter().format(
                AInputRecord("FUBAR lives!")),
                `is`("FUBAR lives!"))
    }
}
