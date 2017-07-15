package hm.binkley.labs.field

import hm.binkley.labs.input.InputRecord

class BarMarkerFormatter<in I> : Formatter<I> where I : InputRecord {
    override fun format(record: I) = "Bar marker?"
}
