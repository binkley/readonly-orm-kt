package hm.binkley.labs.field

import hm.binkley.labs.field.BarMarkerFieldFactory.BarMarkerField
import java.lang.Appendable
import java.sql.PreparedStatement
import java.sql.ResultSet

class BarMarkerFieldFactory : FieldFactory<String, BarMarkerField,
        BarMarkerFieldFactory>(COLUMN, ResultSet::getString, ::BarMarkerField,
        PreparedStatement::setString, Appendable::append) {
    class BarMarkerField(value: String, factory: BarMarkerFieldFactory)
        : Field<String, BarMarkerField, BarMarkerFieldFactory>(value, factory)

    companion object {
        const val COLUMN = "barMarker"

        private val FACTORY = BarMarkerFieldFactory()

        fun barMarker(results: ResultSet): BarMarkerField = FACTORY.read(
                results)

        fun barMarker(value: String): BarMarkerField = FACTORY.of(value)
    }
}
