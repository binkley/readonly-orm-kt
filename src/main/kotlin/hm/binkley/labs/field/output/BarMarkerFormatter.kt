package hm.binkley.labs.field.output

import hm.binkley.labs.field.BarMarkerFieldFactory.BarMarkerField
import hm.binkley.labs.field.BarMarkerFieldFactory.Companion.barMarker
import hm.binkley.labs.input.InputRecord

class BarMarkerFormatter<in I> : Formatter<I, BarMarkerField>
        where I : InputRecord {
    override fun format(record: I) = barMarker("Bar marker?")

    companion object {
        fun <I> barMarker(record: I)
                where I : InputRecord = BarMarkerFormatter<I>().format(record)
    }
}
