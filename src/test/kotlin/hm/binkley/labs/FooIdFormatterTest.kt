package hm.binkley.labs

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

class FooIdFormatterTest {
    @Test
    fun shouldFormat() {
        assertThat(FooIdFormatter().format(AInputRecord("FUBAR lives!")),
                `is`("FUBAR lives!"))
    }
}
