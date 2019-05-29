package app.kundi.safelogs.core

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class FileWriterTest {

    @Test fun `Writes a sample file`() {
        val lines = listOf("a", "b", "c")
        val fileName = File.createTempFile("filewriter", "test").canonicalPath
        FileWriter(lines, fileName)
        val readedLines = FileReader(fileName)
        assertEquals( lines, readedLines )
    }

}
