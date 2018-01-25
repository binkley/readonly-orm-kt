package hm.binkley.labs

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import java.io.File
import java.sql.PreparedStatement
import java.sql.ResultSet

fun <I : InputRecord, O : OutputRecord> build(
        factory: RecordFactory<I, O>, results: ResultSet,
        insert: PreparedStatement, file: File) = results.use { input ->
    file.bufferedWriter().use { output ->
        ResultSetIterator(input).asSequence().map {
            factory.toInputRecord(it)
        }.flatMap { factory.maybeDrop(it) }.map {
            factory.toOutputRecord(it)
        }.onEach { it.save(insert) }.forEach { it.write(output) }
    }
}
