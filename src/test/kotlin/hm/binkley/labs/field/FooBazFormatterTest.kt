package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.FooBazFormatter.Companion

internal class FooBazFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord("FUBAR lives!", 3), Companion::fooBaz,
        "3 × FUBAR lives!")
