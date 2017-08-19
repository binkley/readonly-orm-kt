package hm.binkley.labs.field

import hm.binkley.labs.field.FooBazFieldFactory.FooBazField
import java.lang.Appendable
import java.sql.PreparedStatement
import java.sql.ResultSet

class FooBazFieldFactory : FieldFactory<String, FooBazField,
        FooBazFieldFactory>(COLUMN, ResultSet::getString, ::FooBazField,
        PreparedStatement::setString, Appendable::append) {
    class FooBazField(value: String, factory: FooBazFieldFactory)
        : Field<String, FooBazField, FooBazFieldFactory>(value, factory)

    companion object {
        const val COLUMN = "fooBaz"

        private val FACTORY = FooBazFieldFactory()

        fun fooBaz(results: ResultSet): FooBazField = FACTORY.read(results)

        fun fooBaz(value: String): FooBazField = FACTORY.of(value)
    }
}
