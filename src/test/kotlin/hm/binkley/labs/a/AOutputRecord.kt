package hm.binkley.labs.a

import hm.binkley.labs.field.BarMarkerFormatter.Companion.barMarker
import hm.binkley.labs.field.BazCountFormatter.Companion.bazCount
import hm.binkley.labs.field.FooBazFormatter.Companion.fooBaz
import hm.binkley.labs.field.FooIdFormatter.Companion.fooId
import hm.binkley.labs.input.OutputRecord

data class AOutputRecord(val fooId: String, val barMarker: String,
                         val bazCount: Int, val fooBaz: String)
    : OutputRecord {
    constructor(record: AInputRecord) : this(
            fooId(record),
            barMarker(record),
            bazCount(record),
            fooBaz(record))

    override fun fields(): List<Any?>
            = listOf(fooId, barMarker, bazCount, fooBaz)
}
