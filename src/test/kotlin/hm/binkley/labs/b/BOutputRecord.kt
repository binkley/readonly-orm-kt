package hm.binkley.labs.b

import hm.binkley.labs.field.BarMarkerFieldFactory.BarMarkerField
import hm.binkley.labs.field.BazCountFieldFactory.BazCountField
import hm.binkley.labs.field.FooBazFieldFactory.FooBazField
import hm.binkley.labs.field.FooIdFieldFactory.FooIdField
import hm.binkley.labs.field.QuxMissingFieldFactory.QuxMissingField
import hm.binkley.labs.field.output.BarMarkerFormatter.Companion.barMarker
import hm.binkley.labs.field.output.BazCountFormatter.Companion.bazCount
import hm.binkley.labs.field.output.FooBazFormatter.Companion.fooBaz
import hm.binkley.labs.field.output.FooIdFormatter.Companion.fooId
import hm.binkley.labs.field.output.QuxMissingFormatter.Companion.quxMissing
import hm.binkley.labs.input.HasBazCount
import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord
import hm.binkley.labs.output.OutputRecord
import java.sql.PreparedStatement

data class BOutputRecord(
        private val fooId: FooIdField,
        private val barMarker: BarMarkerField,
        private val bazCount: BazCountField,
        private val fooBaz: FooBazField,
        private val quxMissing: QuxMissingField) : OutputRecord {
    override fun write(out: Appendable) {
        fooId.write(out)
        listOf(barMarker, bazCount, fooBaz, quxMissing).forEach {
            it.write(out.append('|'))
        }
        out.append('\n')
    }

    override fun save(insert: PreparedStatement) {
        listOf(fooId, barMarker, bazCount, fooBaz, quxMissing).withIndex().
                forEach {
                    it.value.save(insert, it.index + 1)
                }
        insert.executeUpdate()
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
