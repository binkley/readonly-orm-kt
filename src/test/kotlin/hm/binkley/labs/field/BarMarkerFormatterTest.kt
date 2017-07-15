package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BarMarkerFormatter.Companion

internal class BarMarkerFormatterTest : FormatterTestBase<AInputRecord>(
        AInputRecord("FUBAR lives?"), Companion::barMarker,
        "Bar marker?")
