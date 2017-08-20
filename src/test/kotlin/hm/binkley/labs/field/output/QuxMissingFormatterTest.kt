package hm.binkley.labs.field.output

import hm.binkley.labs.a.AInputRecord
import hm.binkley.labs.field.BazCountFieldFactory.Companion.bazCount
import hm.binkley.labs.field.FooIdFieldFactory.Companion.fooId
import hm.binkley.labs.field.QuxMissingFieldFactory
import hm.binkley.labs.field.QuxMissingFieldFactory.QuxMissingField

internal class QuxMissingFormatterTest
    : FormatterTestBase<AInputRecord, String?, QuxMissingField, QuxMissingFieldFactory>(
        AInputRecord(fooId("FUBAR lives?"), bazCount(3)),
        QuxMissingFormatter.Companion::quxMissing, null)
