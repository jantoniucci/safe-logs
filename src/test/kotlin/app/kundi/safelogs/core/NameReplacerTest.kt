package app.kundi.safelogs.core

import kotlin.test.Test
import kotlin.test.assertEquals

class NameReplacerTest {

    @Test fun `Replaces a simple name`() {
        assertEquals( "The customer [NAME] logged in",  NameReplacer("The customer Javier logged in", "[NAME]") )
    }

    @Test fun `Replaces a simple full name`() {
        assertEquals( "The customer [NAME] logged in",  NameReplacer("The customer Javier Antoniucci logged in", "[NAME]") )
    }

}
