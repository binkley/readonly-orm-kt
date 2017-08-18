package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.FooIdFormatter.Companion
import hm.binkley.labs.input.HasFooId.Companion.fooId

internal class FooIdFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives!"), 3), Companion::fooId,
        "FUBAR lives!")
