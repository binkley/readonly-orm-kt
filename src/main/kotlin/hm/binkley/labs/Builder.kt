package hm.binkley.labs

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import hm.binkley.labs.output.OutputRecord.Field
import java.io.File
import java.io.Writer
import java.sql.PreparedStatement
import java.sql.ResultSet

fun <I : InputRecord, O : OutputRecord> build(
        factory: RecordFactory<I, O>,
        results: ResultSet,
        write: (O) -> Unit) = results.use { input ->
    ResultSetIterator(input).asSequence().
            map { factory.toInputRecord(it) }.
            flatMap { factory.maybeDrop(it) }.
            map { factory.toOutputRecord(it) }.
            forEach(write)
}

fun <I : InputRecord, O : OutputRecord> build(
        factory: RecordFactory<I, O>,
        results: ResultSet, file: File,
        toLine: (Iterable<Field<*>>) -> String)
        = file.bufferedWriter().use { output ->
    build(factory, results, writeTo(output, toLine))
}

private fun <O : OutputRecord> saveTo(
        insert: PreparedStatement,
        setFields: (PreparedStatement, Iterable<*>) -> Unit): (O) -> Unit = {
    setFields(insert, it.fields())
    insert.executeUpdate()
}

private fun <O : OutputRecord> writeTo(
        output: Writer,
        toLine: (Iterable<OutputRecord.Field<*>>) -> String): (O) -> Unit = {
    output.run {
        append(toLine(it.fields()))
        append('\n')
    }
}
