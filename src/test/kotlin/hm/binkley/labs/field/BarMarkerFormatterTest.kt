package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BarMarkerFormatter.Companion
import hm.binkley.labs.input.HasFooId.Companion.fooId

internal class BarMarkerFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives?"), 3), Companion::barMarker,
        "Bar marker?")
