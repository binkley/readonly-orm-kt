package hm.binkley.labs.a

import hm.binkley.labs.input.HasFooId
import hm.binkley.labs.input.InputRecord

data class AInputRecord(override val fooId: String) : InputRecord, HasFooId
