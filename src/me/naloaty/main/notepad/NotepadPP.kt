package me.naloaty.main.notepad

class NotepadPP(
    private val exe: String
){
    private lateinit var filepath: String
    private var line: Int = 1
    private var col: Int = 1

    fun open(filepath: String): NotepadPP {
        this.filepath = filepath
        return this
    }

    fun ln(ln: Int): NotepadPP {
        this.line = ln
        return this
    }

    fun col(col: Int): NotepadPP {
        this.col = col
        return this
    }

    fun run() {
        val cmd = "\"${this.exe}\" -n${this.line} -c${this.col} ${this.filepath}"
        ProcessBuilder("cmd.exe", "/c", cmd).start()
    }
}