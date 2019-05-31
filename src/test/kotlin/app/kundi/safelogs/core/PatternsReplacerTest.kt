package app.kundi.safelogs.core

import kotlin.test.Test
import kotlin.test.assertEquals

class PatternsReplacerTest {

    @Test fun `Replaces EMAIL patterns`() {
        assertEquals( "My e-mail is [EMAIL] or [EMAIL]",  PatternsReplacer("My e-mail is javier.antoniucci@test.com or jantoniucci@test.com", "[EMAIL]") )
    }

    @Test fun `Replaces CREDITCARD patterns`() {
        assertEquals( "My Creditcard is [CREDITCARD] or [CREDITCARD]",  PatternsReplacer("My Creditcard is 0000 0000 0000 0000 or 1234-5678-9012-3456", "[CREDITCARD]") )
    }

    @Test fun `Replaces ZIPCODE patterns`() {
        assertEquals( "My Zipcode is [ZIPCODE] or [ZIPCODE]",  PatternsReplacer("My Zipcode is 55555-4444 or 11111-2222", "[ZIPCODE]") )
    }

    @Test fun `Replaces IPADDRESS patterns`() {
        assertEquals( "Accessing from [IPADDRESS] and proxy [IPADDRESS]",  PatternsReplacer("Accessing from 127.0.0.1:8080 and proxy 192.168.0.250", "[IPADDRESS]") )
    }

    @Test fun `Replaces USERNAME patterns`() {
        assertEquals( "My [USERNAME] and my [USERNAME]",  PatternsReplacer("My username is jantoniucci and my user: jantoniucci", "[USERNAME]") )
    }

    @Test fun `Replaces PASSWORD patterns`() {
        assertEquals( "My [PASSWORD]",  PatternsReplacer("My password is aaa", "[PASSWORD]") )
    }

    @Test fun `Replaces CREDENTIALS patterns`() {
        assertEquals( "My [CREDENTIALS] and also [CREDENTIALS]",  PatternsReplacer("My login credential is jantoniucci and also login: javierantoniucci", "[CREDENTIALS]") )
    }


}
