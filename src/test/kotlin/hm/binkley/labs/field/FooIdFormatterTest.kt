package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.FooIdFormatter.Companion

internal class FooIdFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord("FUBAR lives!", 3), Companion::fooId, "FUBAR lives!")
