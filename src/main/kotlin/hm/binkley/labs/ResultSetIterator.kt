package hm.binkley.labs

import java.sql.ResultSet

class ResultSetIterator(
        private val results: ResultSet) : Iterator<ResultSet> {
    override fun hasNext() = results.next()

    override fun next(): ResultSet {
        if (results.isBeforeFirst || results.isAfterLast)
            throw NoSuchElementException()
        return results
    }
}
