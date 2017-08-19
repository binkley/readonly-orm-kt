package hm.binkley.labs.field

import hm.binkley.labs.field.BazCountFieldFactory.BazCountField
import java.sql.PreparedStatement
import java.sql.ResultSet

class BazCountFieldFactory : FieldFactory<Int, BazCountField,
        BazCountFieldFactory>(COLUMN, ResultSet::getInt, ::BazCountField,
        PreparedStatement::setInt,
        { appendable, v -> appendable.append(v.toString()) }) {
    class BazCountField(value: Int, factory: BazCountFieldFactory)
        : Field<Int, BazCountField, BazCountFieldFactory>(value,
            factory)

    companion object {
        const val COLUMN = "bazCount"

        private val FACTORY = BazCountFieldFactory()

        fun bazCount(results: ResultSet): BazCountField
                = FACTORY.read(results)

        fun bazCount(value: Int): BazCountField = FACTORY.of(value)
    }
}
