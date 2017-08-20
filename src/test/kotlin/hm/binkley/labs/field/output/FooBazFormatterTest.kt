package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooBazFieldFactory.FooBazField
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId

internal class FooBazFormatterTest
    : FormatterTestBase<AInputRecord, String, FooBazField>(
        AInputRecord(fooId("FUBAR lives!"), bazCount(3)),
        FooBazFormatter.Companion::fooBaz, "3 × FUBAR lives!")
