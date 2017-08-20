package hm.binkley.labs.field.output

import hm.binkley.labs.field.QuxMissingFieldFactory
import hm.binkley.labs.field.QuxMissingFieldFactory.QuxMissingField
import hm.binkley.labs.input.InputRecord

class QuxMissingFormatter<in I> : Formatter<I, QuxMissingField>
        where I : InputRecord {
    override fun format(record: I) = QuxMissingFieldFactory.quxMissing(null)

    companion object {
        fun <I> quxMissing(record: I)
                where I : InputRecord
                = QuxMissingFormatter<I>().format(record)
    }
}
