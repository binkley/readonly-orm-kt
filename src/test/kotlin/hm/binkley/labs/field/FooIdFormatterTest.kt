package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.FooIdFormatter.Companion

internal class FooIdFormatterTest : FormatterTestBase<AInputRecord>(
        AInputRecord("FUBAR lives!"), Companion::fooId,
        "FUBAR lives!")
