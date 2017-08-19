package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId
import hm.binkley.labs.field.output.BarMarkerFormatter.Companion.barMarker

internal class BarMarkerFormatterTest
    : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives?"), bazCount(3)),
        { record -> barMarker(record).value }, "Bar marker?")