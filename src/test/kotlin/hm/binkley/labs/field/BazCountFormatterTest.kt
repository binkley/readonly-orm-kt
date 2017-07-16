package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFormatter.Companion

internal class BazCountFormatterTest : FormatterTestBase<AInputRecord, Int>(
        AInputRecord("FUBAR lives!", 3), Companion::bazCount, 3)
