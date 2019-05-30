package app.kundi.safelogs.core

import kotlin.test.Test
import kotlin.test.assertEquals

class OrganizationReplacerTest {

    @Test fun `Replaces a simple location`() {
        assertEquals( "The customer belongs to [ORGANIZATION]",  OrganizationReplacer("The customer belongs to Soda Company Inc", "[ORGANIZATION]") )
    }

}
