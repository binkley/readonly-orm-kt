package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BarMarkerFormatter.Companion.barMarker
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test

internal class BarMarkerFormatterTest {
    @Test
    fun shouldFormat() {
        assertThat(barMarker(AInputRecord("FUBAR lives!")),
                `is`("Bar marker?"))
    }
}
