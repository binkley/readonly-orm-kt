package hm.binkley.labs.b

import hm.binkley.labs.field.FooIdFieldFactory.FooIdField
import hm.binkley.labs.field.output.BarMarkerFormatter.Companion.barMarker
import hm.binkley.labs.field.output.BarMarkerFormatter.Companion.barMarkerField
import hm.binkley.labs.field.output.BazCountFormatter.Companion.bazCount
import hm.binkley.labs.field.output.BazCountFormatter.Companion.bazCountField
import hm.binkley.labs.field.output.FooBazFormatter.Companion.fooBaz
import hm.binkley.labs.field.output.FooBazFormatter.Companion.fooBazField
import hm.binkley.labs.field.output.FooIdFormatter.Companion.fooId
import hm.binkley.labs.field.output.FooIdFormatter.Companion.fooIdField
import hm.binkley.labs.field.output.QuxMissingFormatter.Companion.quxMissing
import hm.binkley.labs.field.output.QuxMissingFormatter.Companion.quxMissingField
import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord

data class BOutputRecord(
        private val fooId: FooIdField,
        private val barMarker: String,
        private val bazCount: Int,
        private val fooBaz: String,
        private val quxMissing: String) : OutputRecord {
    override fun fields() = listOf(fooIdField(fooId.value),
            barMarkerField(barMarker),
            bazCountField(bazCount), fooBazField(fooBaz),
            quxMissingField(quxMissing))

    companion object {
        /**
         * @todo This should be a secondary constructor, when Kotlin supports
         * generics on those
         */
        fun <I> asBOutputRecord(record: I)
                where I : InputRecord, I : HasFooId, I : HasBazCount = BOutputRecord(
                fooId(record), barMarker(record), bazCount(record),
                fooBaz(record), quxMissing(record))
    }
}
