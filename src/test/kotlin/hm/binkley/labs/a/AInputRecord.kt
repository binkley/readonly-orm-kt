package hm.binkley.labs.a

import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasBazCount.Companion.BazCountFieldFactory.BazCountField
import hm.binkley.labs.input.HasBazCount.Companion.bazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.HasFooId.Companion.FooIdFieldFactory.FooIdField
import hm.binkley.labs.input.HasFooId.Companion.fooId
import hm.binkley.labs.input.InputRecord
import java.sql.ResultSet

data class AInputRecord(
        override val fooId: FooIdField,
        override val bazCount: BazCountField)
    : InputRecord, HasFooId, HasBazCount {
    constructor(results: ResultSet) : this(fooId(results), bazCount(results))
}
