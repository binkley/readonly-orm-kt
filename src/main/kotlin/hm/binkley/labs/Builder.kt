package hm.binkley.labs

import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import java.io.File
import java.sql.ResultSet

fun <I : InputRecord, O : OutputRecord> build(
        results: ResultSet,
        file: File,
        toInputRecord: (ResultSet) -> I,
        toOutputRecord: (I) -> O,
        toLine: (List<*>) -> String) = results.use { input ->
    file.bufferedWriter().use { output ->
        ResultSetIterator(input).asSequence().
                map(toInputRecord).
                map(toOutputRecord).
                map { it.fields() }.
                map(toLine).
                forEach { output.append(it); output.append('\n') }
    }
}

private class ResultSetIterator(
        private val results: ResultSet) : Iterator<ResultSet> {
    override fun hasNext() = results.next()

    override fun next() = results
}
