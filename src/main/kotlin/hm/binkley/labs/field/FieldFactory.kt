package hm.binkley.labs.field

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinToString
import hm.binkley.labs.field.FieldFactory.Field
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.Objects

abstract class FieldFactory<T, F : Field<T, F, C>, C : FieldFactory<T, F,
        C>> protected constructor(
        private val column: String,
        private val reader: (ResultSet, String) -> T,
        private val ctor: (T, C) -> F,
        private val saver: (PreparedStatement, Int, T) -> Unit,
        private val writer: (Appendable, T) -> Appendable) {
    fun read(results: ResultSet) = of(reader(results, column))

    @Suppress("UNCHECKED_CAST")
    fun of(value: T) = ctor(value, this as C)

    abstract class Field<T, F : Field<T, F, C>, C : FieldFactory<T, F,
            C>> protected constructor(
            val value: T,
            private val factory: C) {
        fun save(insert: PreparedStatement, index: Int)
                = factory.saver(insert, index, value)

        fun write(out: Appendable) = factory.writer(out, value)

        override fun equals(other: Any?)
                = kotlinEquals(other, properties)

        override fun hashCode() = Objects.hash(value, factory)

        override fun toString() = kotlinToString(properties)

        companion object {
            private val properties = arrayOf(Field<*, *, *>::value,
                    Field<*, *, *>::factory)
        }
    }
}
