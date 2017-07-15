package hm.binkley.labs.a

import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import java.sql.ResultSet

data class AInputRecord(override val fooId: String,
                        override val bazCount: Int)
    : InputRecord, HasFooId, HasBazCount {
    constructor(results: ResultSet)
            : this(results.getString("fooId"), results.getInt("bazCount"))
}
