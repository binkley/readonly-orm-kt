package hm.binkley.labs

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import java.io.File
import java.io.Writer
import java.sql.ResultSet

fun <I : InputRecord, O : OutputRecord> build(results: ResultSet,
        toInputRecord: (ResultSet) -> I, toOutputRecord: (I) -> O,
        write: (O) -> Unit) = results.use { input ->
    ResultSetIterator(input).asSequence().map(toInputRecord).map(
            toOutputRecord).forEach(write)
}

fun <I : InputRecord, O : OutputRecord> build(results: ResultSet, file: File,
        toInputRecord: (ResultSet) -> I, toOutputRecord: (I) -> O,
        toLine: (List<*>) -> String) = file.bufferedWriter().use { output ->
    build(results, toInputRecord, toOutputRecord, writeTo(output, toLine))
}

private fun <O : OutputRecord> writeTo(output: Writer,
        toLine: (List<*>) -> String): (O) -> Unit = {
    output.run {
        append(toLine(it.fields().map { it.value }))
        append('\n')
    }
}

private class ResultSetIterator(
        private val results: ResultSet) : Iterator<ResultSet> {
    override fun hasNext() = results.next()

    override fun next() = results
}
