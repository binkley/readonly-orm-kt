package hm.binkley.labs.field

import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord

class FooIdFormatter<in I> : Formatter<I> where I : InputRecord, I : HasFooId {
    override fun format(record: I) = record.fooId

    companion object {
        fun <I> fooId(record: I): String where I : InputRecord, I : HasFooId
                = FooIdFormatter<I>().format(record)
    }
}
