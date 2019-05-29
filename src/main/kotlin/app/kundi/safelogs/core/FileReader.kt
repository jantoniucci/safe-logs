package app.kundi.safelogs.core

import java.io.File

val FileReader: Reader = {
    origin ->
        File(origin).readLines()
}

