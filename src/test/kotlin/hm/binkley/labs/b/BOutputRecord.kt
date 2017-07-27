package hm.binkley.labs.b

import hm.binkley.labs.field.BarMarkerFormatter.Companion.barMarker
import hm.binkley.labs.field.BarMarkerFormatter.Companion.barMarkerField
import hm.binkley.labs.field.BazCountFormatter.Companion.bazCount
import hm.binkley.labs.field.BazCountFormatter.Companion.bazCountField
import hm.binkley.labs.field.FooBazFormatter.Companion.fooBaz
import hm.binkley.labs.field.FooBazFormatter.Companion.fooBazField
import hm.binkley.labs.field.FooIdFormatter.Companion.fooId
import hm.binkley.labs.field.FooIdFormatter.Companion.fooIdField
import hm.binkley.labs.field.QuxMissingFormatter.Companion.quxMissing
import hm.binkley.labs.field.QuxMissingFormatter.Companion.quxMissingField
import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import org.jetbrains.exposed.sql.Table

data class BOutputRecord(private val fooId: String,
        private val barMarker: String, private val bazCount: Int,
        private val fooBaz: String,
        private val quxMissing: String) : OutputRecord {
    override fun fields() = listOf(fooIdField(fooId), barMarkerField(barMarker),
            bazCountField(bazCount), fooBazField(fooBaz),
            quxMissingField(quxMissing))

    override fun table(): Table = object : Table() {
        val fooId = text("foo_id").primaryKey()
        val barMarker = text("bar_marker")
        val bazCount = integer("baz_count")
        val fooBaz = text("foo_baz")
        val quxMissing = text("qux_missing").nullable()
    }

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
