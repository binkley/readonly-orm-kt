package hm.binkley.labs.field

import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord.Field

class FooIdFormatter<in I> : Formatter<I, String>
where I : InputRecord, I : HasFooId {
    override fun format(record: I) = record.fooId

    companion object {
        fun <I> fooId(record: I)
                where I : InputRecord, I : HasFooId = FooIdFormatter<I>().format(
                record)

        fun fooIdField(value: String) = Field("fooId", value,
                String::class.java)
    }
}
