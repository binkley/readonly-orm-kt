package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.output.QuxMissingFormatter.Companion
import hm.binkley.labs.input.HasBazCount.Companion.bazCount
import hm.binkley.labs.input.HasFooId.Companion.fooId

internal class QuxMissingFormatterTest
    : FormatterTestBase<AInputRecord, String>(
        AInputRecord(fooId("FUBAR lives?"), bazCount(3)),
        Companion::quxMissing, "")
