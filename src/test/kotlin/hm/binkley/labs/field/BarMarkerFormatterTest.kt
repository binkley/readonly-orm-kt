package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BarMarkerFormatter.Companion

internal class BarMarkerFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord("FUBAR lives?", 3), Companion::barMarker, "Bar marker?")
