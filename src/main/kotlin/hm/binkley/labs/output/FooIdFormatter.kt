package hm.binkley.labs.output

import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord

class FooIdFormatter {
    fun <I> format(record: I)where I : InputRecord, I : HasFooId
            = record.fooId
}
