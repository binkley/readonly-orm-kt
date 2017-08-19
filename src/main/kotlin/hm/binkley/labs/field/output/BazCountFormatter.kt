package hm.binkley.labs.field.output

import hm.binkley.labs.field.BazCountFieldFactory.BazCountField
import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.InputRecord

class BazCountFormatter<in I> : Formatter<I, BazCountField>
        where I : InputRecord, I : HasBazCount {
    override fun format(record: I) = record.bazCount

    companion object {
        fun <I> bazCount(record: I)
                where I : InputRecord, I : HasBazCount
                = BazCountFormatter<I>().format(record)
    }
}
