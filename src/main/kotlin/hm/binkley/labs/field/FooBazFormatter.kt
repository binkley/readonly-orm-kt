package hm.binkley.labs.field

import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord.Field

class FooBazFormatter<in I> : Formatter<I, String>
        where I : InputRecord, I : HasFooId, I : HasBazCount {
    override fun format(record: I)
            = "${record.bazCount.value} × ${record.fooId.value}"

    companion object {
        fun <I> fooBaz(record: I)
                where I : InputRecord, I : HasFooId, I : HasBazCount
                = FooBazFormatter<I>().format(record)

        fun fooBazField(value: String)
                = Field("fooBaz", value, String::class.java)
    }
}
