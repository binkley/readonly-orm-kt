package hm.binkley.labs.field

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.QuxMissingFormatter.Companion

internal class QuxMissingFormatterTest : FormatterTestBase<AInputRecord, String>(
        AInputRecord("FUBAR lives?", 3), Companion::quxMissing, "")
