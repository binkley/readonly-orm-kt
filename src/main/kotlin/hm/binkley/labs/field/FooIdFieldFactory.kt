package hm.binkley.labs.field

import hm.binkley.labs.field.FooIdFieldFactory.FooIdField
import java.lang.Appendable
import java.sql.PreparedStatement
import java.sql.ResultSet

class FooIdFieldFactory : FieldFactory<String, FooIdField,
        FooIdFieldFactory>(COLUMN, ResultSet::getString, ::FooIdField,
        PreparedStatement::setString, Appendable::append) {
    class FooIdField(value: String, factory: FooIdFieldFactory)
        : Field<String, FooIdField, FooIdFieldFactory>(value, factory)

    companion object {
        const val COLUMN = "fooId"

        private val FACTORY = FooIdFieldFactory()

        fun fooId(results: ResultSet): FooIdField = FACTORY.read(results)

        fun fooId(value: String): FooIdField = FACTORY.of(value)
    }
}
