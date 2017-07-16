package hm.binkley.labs.field

import hm.binkley.labs.input.InputRecord

class QuxMissingFormatter<in I> : Formatter<I, String>
where I : InputRecord {
    override fun format(record: I) = ""

    companion object {
        fun <I> quxMissing(record: I)
                where I : InputRecord
                = QuxMissingFormatter<I>().format(record)
    }
}
