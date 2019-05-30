package app.kundi.safelogs.core

import kotlin.test.Test
import kotlin.test.assertEquals

class LocationReplacerTest {

    @Test fun `Replaces a simple location`() {
        assertEquals( "The customer city is [LOCATION]",  LocationReplacer("The customer city is New York", "[LOCATION]") )
    }

}
