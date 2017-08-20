package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BarMarkerFieldFactory.BarMarkerField
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId

internal class BarMarkerFormatterTest
    : FormatterTestBase<AInputRecord, String, BarMarkerField>(
        AInputRecord(fooId("FUBAR lives?"), bazCount(3)),
        BarMarkerFormatter.Companion::barMarker, "Bar marker?")
