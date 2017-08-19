package hm.binkley.labs.field

import hm.binkley.labs.field.QuxMissingFieldFactory.QuxMissingField
import java.lang.Appendable
import java.sql.PreparedStatement
import java.sql.ResultSet

class QuxMissingFieldFactory : FieldFactory<String, QuxMissingField,
        QuxMissingFieldFactory>(COLUMN, ResultSet::getString,
        ::QuxMissingField, PreparedStatement::setString, Appendable::append) {
    class QuxMissingField(value: String, factory: QuxMissingFieldFactory)
        : Field<String, QuxMissingField, QuxMissingFieldFactory>(value,
            factory)

    companion object {
        const val COLUMN = "quxMissing"

        private val FACTORY = QuxMissingFieldFactory()

        fun quxMissing(results: ResultSet): QuxMissingField
                = FACTORY.read(results)

        fun quxMissing(value: String): QuxMissingField = FACTORY.of(value)
    }
}
