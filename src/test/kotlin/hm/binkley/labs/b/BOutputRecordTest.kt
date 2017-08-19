package hm.binkley.labs.b

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.b.BOutputRecord.Companion.asBOutputRecord
import hm.binkley.labs.input.HasBazCount.Companion.bazCount
import hm.binkley.labs.input.HasFooId.Companion.fooId
import org.hamcrest.Matchers.`is`
import org.hamcrest.junit.MatcherAssert.assertThat
import org.junit.Test

internal class BOutputRecordTest {
    @Test
    fun shouldConvert() {
        assertThat(asBOutputRecord(AInputRecord(fooId("FUBAR lives!"),
                bazCount(3))),
                `is`(BOutputRecord("FUBAR lives!", "Bar marker?", 3,
                        "3 × FUBAR lives!", "")))
    }
}
