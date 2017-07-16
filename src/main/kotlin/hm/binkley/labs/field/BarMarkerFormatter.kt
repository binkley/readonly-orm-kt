package hm.binkley.labs.field

import hm.binkley.labs.input.InputRecord

class BarMarkerFormatter<in I> : Formatter<I, String>
where I : InputRecord {
    override fun format(record: I) = "Bar marker?"

    companion object {
        fun <I> barMarker(record: I)
                where I : InputRecord
                = BarMarkerFormatter<I>().format(record)
    }
}
