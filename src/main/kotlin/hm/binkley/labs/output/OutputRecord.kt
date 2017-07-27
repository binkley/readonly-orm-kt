package hm.binkley.labs.output

import org.jetbrains.exposed.sql.Table

interface OutputRecord {
    fun fields(): List<Field<*>>

    fun table(): Table

    data class Field<T>(val name: String, val value: T, val type: Class<T>)
}
