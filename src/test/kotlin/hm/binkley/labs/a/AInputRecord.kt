package hm.binkley.labs.a

import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import org.jetbrains.exposed.sql.Table
import java.sql.ResultSet

data class AInputRecord(override val fooId: String,
        override val bazCount: Int) : InputRecord, HasFooId, HasBazCount {
    constructor(results: ResultSet) : this(results.getString("fooId"),
            results.getInt("bazCount"))

    override fun table(): Table = object : Table() {
        val fooId = text("foo_id").primaryKey()
        val bazCount = integer("baz_count")
    }
}
