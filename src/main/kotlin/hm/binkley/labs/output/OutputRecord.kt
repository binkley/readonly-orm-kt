package hm.binkley.labs.output

interface OutputRecord {
    fun fields(): Iterable<Field<*>>

    data class Field<T>(val name: String, val value: T, val type: Class<T>)
}
