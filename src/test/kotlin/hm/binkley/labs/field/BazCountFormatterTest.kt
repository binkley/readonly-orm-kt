package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFormatter.Companion
import hm.binkley.labs.input.HasFooId.Companion.fooId

internal class BazCountFormatterTest : FormatterTestBase<AInputRecord, Int>(
        AInputRecord(fooId("FUBAR lives!"), 3), Companion::bazCount, 3)
