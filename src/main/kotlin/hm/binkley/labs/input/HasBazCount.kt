package hm.binkley.labs.input

import hm.binkley.labs.field.FieldFactory
import hm.binkley.labs.input.HasBazCount.Companion.BazCountFieldFactory
        .BazCountField
import java.sql.PreparedStatement
import java.sql.ResultSet

interface HasBazCount {
    val bazCount: BazCountField

    companion object {
        const val COLUMN = "bazCount"

        class BazCountFieldFactory : FieldFactory<Int, BazCountField,
                BazCountFieldFactory>(COLUMN, ResultSet::getInt,
                ::BazCountField, PreparedStatement::setInt,
                { appendable, v -> appendable.append(v.toString()) }) {
            class BazCountField(value: Int, factory: BazCountFieldFactory)
                : Field<Int, BazCountField, BazCountFieldFactory>(value,
                    factory)
        }

        private val FACTORY = BazCountFieldFactory()

        fun bazCount(results: ResultSet): BazCountField
                = FACTORY.read(results)

        fun bazCount(value: Int): BazCountField = FACTORY.of(value)
    }
}
