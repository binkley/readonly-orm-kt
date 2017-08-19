package hm.binkley.labs.field.output

import hm.binkley.labs.field.QuxMissingFieldFactory
import hm.binkley.labs.field.QuxMissingFieldFactory.QuxMissingField
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord.Field

class QuxMissingFormatter<in I> : Formatter<I, QuxMissingField>
        where I : InputRecord {
    override fun format(record: I) = QuxMissingFieldFactory.quxMissing("")

    companion object {
        fun <I> quxMissing(record: I)
                where I : InputRecord = QuxMissingFormatter<I>().format(
                record)

        fun quxMissingField(value: String) = Field("quxMissing", value,
                String::class.java)
    }
}
