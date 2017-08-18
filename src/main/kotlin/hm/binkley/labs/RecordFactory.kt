package hm.binkley.labs

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import java.sql.ResultSet

interface RecordFactory<I : InputRecord, out O : OutputRecord> {
    fun toInputRecord(results: ResultSet): I

    fun maybeDrop(inputRecord: I): Sequence<I>

    fun toOutputRecord(inputRecord: I): O
}
