package hm.binkley.labs.output

import java.sql.PreparedStatement

interface OutputRecord {
    fun save(insert: PreparedStatement)

    fun write(out: Appendable)
}
