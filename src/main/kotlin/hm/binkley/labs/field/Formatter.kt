package hm.binkley.labs.field

import hm.binkley.labs.input.InputRecord

interface Formatter<in I : InputRecord> {
    fun format(record: I): String
}
