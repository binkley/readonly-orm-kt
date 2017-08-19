package hm.binkley.labs.field.output

import hm.binkley.labs.input.InputRecord

interface Formatter<in I : InputRecord, out T> {
    fun format(record: I): T
}
