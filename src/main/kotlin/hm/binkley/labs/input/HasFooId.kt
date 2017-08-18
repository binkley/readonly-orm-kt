package hm.binkley.labs.input

import hm.binkley.labs.field.FieldFactory
import hm.binkley.labs.input.HasFooId.Companion.FooIdFieldFactory.FooIdField
import java.lang.Appendable
import java.sql.PreparedStatement
import java.sql.ResultSet

interface HasFooId {
    val fooId: FooIdField

    companion object {
        const val COLUMN = "fooId"

        class FooIdFieldFactory : FieldFactory<String, FooIdField,
                FooIdFieldFactory>(COLUMN, ResultSet::getString,
                ::FooIdField, PreparedStatement::setString,
                Appendable::append) {
            class FooIdField(value: String, factory: FooIdFieldFactory)
                : Field<String, FooIdField, FooIdFieldFactory>(value,
                    factory)
        }

        private val FACTORY = FooIdFieldFactory()

        fun fooId(results: ResultSet): FooIdField = FACTORY.read(results)
        fun fooId(value: String): FooIdField = FACTORY.of(value)
    }
}
