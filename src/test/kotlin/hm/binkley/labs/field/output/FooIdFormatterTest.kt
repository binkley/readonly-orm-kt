package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId

internal class FooIdFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives!"), bazCount(3)),
        { record -> FooIdFormatter.fooId(record).value }, "FUBAR lives!")
