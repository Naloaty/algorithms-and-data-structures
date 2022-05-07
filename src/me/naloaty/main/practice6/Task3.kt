package me.naloaty.main.practice6

import me.naloaty.main.notepad.NotepadPP
import java.io.File

fun bmFind(source: String, template: Template, startIndex: Int = 0): Int {
    val tl = template.length
    val sl = source.length

    var i = startIndex
    var j = tl - 1

    // iterate until we reach the source end or find the template match
    while (i <= sl - tl && j >= 0) {
        if (source[i + j] == template[j]) { // chars are equal
            j-- // check next char to the left of the previous one
        }
        else {
            if (j == tl - 1) { // last chars are not equal
                // get shift value by a char in the SOURCE
                i += template.shift(source[i + j])
                j = tl - 1
            }
            else { // chars are not equal somewhere in the middle
                // get shift value by the LAST char in the TEMPLATE
                i += template.shift(template[tl - 1])
                j = tl - 1
            }
        }
    }

    return if (j == -1) i else -1
}


fun main() {
    val filepath = "D:/TEXT.txt"
    val padpath  = "C:/Program Files/Notepad++/notepad++.exe"

    print("Template: ")
    val template = Template(readln())
    val notepad  = NotepadPP(padpath).open(filepath)

    File(filepath).useLines {
        var line = 1
        var col = -1

        for (str in it.iterator()) {
            col = bmFind(str, template)

            if (col != -1) {
                println("Ln $line, col ${col + 1}")
                notepad.ln(line).col(col + 1).run()
                return
            }

            line++
        }

        println("Not found")
    }
}