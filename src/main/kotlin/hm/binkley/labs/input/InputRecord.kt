package hm.binkley.labs.input

import org.jetbrains.exposed.sql.Table

interface InputRecord {
    fun table(): Table
}
