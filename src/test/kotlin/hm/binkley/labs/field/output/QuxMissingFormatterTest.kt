package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId

internal class QuxMissingFormatterTest
    : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives?"), bazCount(3)),
        { record -> QuxMissingFormatter.quxMissing(record).value }, "")
