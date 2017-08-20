package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId
import hm.binkley.labs.field.FooIdFieldFactory.FooIdField

internal class FooIdFormatterTest
    : FormatterTestBase<AInputRecord, String, FooIdField>(
        AInputRecord(fooId("FUBAR lives!"), bazCount(3)),
        FooIdFormatter.Companion::fooId, "FUBAR lives!")
