package hm.binkley.labs.output

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.input.HasFooId

class FooIdFormatter {
    fun format(record: InputRecord): String = (record as HasFooId).fooId
}
