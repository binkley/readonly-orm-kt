package hm.binkley.labs.field.output

import hm.binkley.labs.field.FooBazFieldFactory.Companion.fooBaz
import hm.binkley.labs.field.FooBazFieldFactory.FooBazField
import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord

class FooBazFormatter<in I> : Formatter<I, FooBazField>
        where I : InputRecord, I : HasFooId, I : HasBazCount {
    override fun format(record: I)
            = fooBaz("${record.bazCount.value} × ${record.fooId.value}")

    companion object {
        fun <I> fooBaz(record: I)
                where I : InputRecord, I : HasFooId, I : HasBazCount
                = FooBazFormatter<I>().format(record)
    }
}
