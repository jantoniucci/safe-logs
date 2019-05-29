package app.kundi.safelogs.core

import java.io.File

val FileWriter: Writer = {
        lines, target ->

    File(target).printWriter().use { out -> lines.forEach { line -> out.println(line) } }

}

