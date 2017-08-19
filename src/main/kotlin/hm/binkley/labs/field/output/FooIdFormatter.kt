package hm.binkley.labs.field.output

import hm.binkley.labs.field.FooIdFieldFactory.FooIdField
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord

class FooIdFormatter<in I> : Formatter<I, FooIdField>
        where I : InputRecord, I : HasFooId {
    override fun format(record: I) = record.fooId

    companion object {
        fun <I> fooId(record: I)
                where I : InputRecord, I : HasFooId
                = FooIdFormatter<I>().format(record)
    }
}
