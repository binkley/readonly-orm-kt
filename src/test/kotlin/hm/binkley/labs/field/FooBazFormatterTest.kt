package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.FooBazFormatter.Companion
import hm.binkley.labs.input.HasFooId.Companion.fooId

internal class FooBazFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives!"), 3), Companion::fooBaz,
        "3 × FUBAR lives!")
