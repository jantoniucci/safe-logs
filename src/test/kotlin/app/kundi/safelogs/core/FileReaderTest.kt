package app.kundi.safelogs.core

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class FileReaderTest {

    @Test fun `Reads a sample file`() {
        val exampleLines = File("./examples/example.log").readLines()
        assertEquals( exampleLines, FileReader("./examples/example.log") )
    }

}
