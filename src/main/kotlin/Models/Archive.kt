package Models

data class Archive(val title: String) {
    private val notes: MutableList<Note> = mutableListOf()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getNoteByTitle(title: String): Note? {
        return notes.find { it.title == title }
    }

    fun getNotes(): List<Note> {
        return notes
    }
}