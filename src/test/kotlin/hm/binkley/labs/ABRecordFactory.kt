package hm.binkley.labs

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.b.BOutputRecord
import java.sql.ResultSet

class ABRecordFactory : RecordFactory<AInputRecord, BOutputRecord> {
    override fun toInputRecord(results: ResultSet): AInputRecord {
        return AInputRecord(results)
    }

    override fun toOutputRecord(inputRecord: AInputRecord): BOutputRecord {
        return BOutputRecord.asBOutputRecord(inputRecord)
    }
}
