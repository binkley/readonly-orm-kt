package hm.binkley.labs.field.output

import hm.binkley.labs.field.BazCountFieldFactory.BazCountField
import hm.binkley.labs.field.BazCountFieldFactory.Companion.COLUMN
import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord.Field

class BazCountFormatter<in I> : Formatter<I, BazCountField>
        where I : InputRecord, I : HasBazCount {
    override fun format(record: I) = record.bazCount

    companion object {
        fun <I> bazCount(record: I)
                where I : InputRecord, I : HasBazCount
                = BazCountFormatter<I>().format(record)

        fun bazCountField(value: Int)
                = Field(COLUMN, value, Int::class.java)
    }
}
