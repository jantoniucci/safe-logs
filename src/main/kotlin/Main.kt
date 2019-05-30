import app.kundi.safelogs.core.FileReader
import app.kundi.safelogs.core.FileWriter
import app.kundi.safelogs.core.LocationReplacer
import app.kundi.safelogs.core.NameReplacer
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.file
import kotlin.system.measureTimeMillis

class Main : CliktCommand(name = "swagger-dictionary",
    help = "Creates and validates a terms dictionary with a swagger file") {

    private val sourceFile by argument("sourceFile", help = "The source file to be sanitized (production log, csv, etc)")
        .file(exists = true)

    private val targetFile by argument("targetFile", help = "The target path and file name")
        .file(exists = false)

    private val nameReplacement: String by option(help="Text to be replaced for each Name/Surname found").default("[NAME]")

    private val locationReplacement: String by option(help="Text to be replaced for each location found").default("[LOCATION]")

    override fun run() {
        printStartingMessage()
        val elapsedTime = measureTimeMillis {
            val reader = FileReader(sourceFile.absolutePath)
            val sanitizedLines = reader
                .map {NameReplacer(it, nameReplacement)}
                .map { LocationReplacer(it, locationReplacement) }
            FileWriter(sanitizedLines, targetFile.absolutePath)
        }
        printEndMessage(elapsedTime)

    }

    private fun printEndMessage(elapsedTime: Long) {
        echo("")
        echo("* End")
        echo("")
        echo("  - elapsedTime : ${elapsedTime} millis")
        echo("")
    }

    fun printStartingMessage() {
        echo("")
        echo("* Starting...")
        echo("")
        echo("  - source file : ${sourceFile.absolutePath} ")
        echo("  - target file : ${targetFile.absolutePath} ")
        echo("")
        echo("* Running...")
        echo("")
    }
}

fun main(args: Array<String>) = Main().main(args)