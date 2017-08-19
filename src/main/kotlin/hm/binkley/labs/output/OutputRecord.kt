package hm.binkley.labs.output

import java.sql.PreparedStatement

interface OutputRecord {
    fun write(out: Appendable)

    fun save(insert: PreparedStatement)
}
