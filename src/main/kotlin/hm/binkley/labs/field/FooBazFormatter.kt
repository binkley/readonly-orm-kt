package hm.binkley.labs.field

import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord

class FooBazFormatter<in I> : Formatter<I>
where I : InputRecord, I : HasFooId, I : HasBazCount {
    override fun format(record: I) = "${record.bazCount} × ${record.fooId}"

    companion object {
        fun <I> fooBaz(record: I)
                where I : InputRecord, I : HasFooId, I : HasBazCount
                = FooBazFormatter<I>().format(record)
    }
}
