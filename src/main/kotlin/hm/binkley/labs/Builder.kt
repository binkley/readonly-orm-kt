package hm.binkley.labs

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import java.io.File
import java.sql.ResultSet

fun <I : InputRecord, O : OutputRecord> build(
        factory: RecordFactory<I, O>,
        results: ResultSet, file: File)
        = results.use { input ->
    file.bufferedWriter().use { output ->
        ResultSetIterator(input).asSequence().
                map { factory.toInputRecord(it) }.
                flatMap { factory.maybeDrop(it) }.
                map { factory.toOutputRecord(it) }.
                forEach { it.write(output) }
    }
}
