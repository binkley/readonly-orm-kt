package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId
import hm.binkley.labs.field.output.BazCountFormatter.Companion

internal class BazCountFormatterTest : FormatterTestBase<AInputRecord, Int>(
        AInputRecord(fooId("FUBAR lives!"), bazCount(3)),
        Companion::bazCount, 3)
