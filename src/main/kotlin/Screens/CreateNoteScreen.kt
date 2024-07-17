package Screens

import App
import Models.*

class CreateNoteScreen(val archive: Archive) : IScreen {
    override val menu = Menu(this)
    override val screenTitle = "Создание заметки"
    override val listOfCommands: MutableList<MenuCommand> = mutableListOf()
    override val customInputProcess = true
    override var customInputMessage = "Введите уникальное название заметки (Оставьте поле пустым для отмены создания):"

    var noteTitle = ""

    override fun processInput(input: String) {
        if (input.isEmpty()) {
            App.setScreen(ArchiveScreen(archive))
        }
        if (noteTitle.isEmpty()) {
            if (archive.getNoteByTitle(input) != null) {
                println("Заметка с таким названием уже существует")
                return
            }
            noteTitle = input
            customInputMessage = "Введите содержимое заметки (Оставьте поле пустым для отмены создания):"
            return
        }

        archive.addNote(Note(noteTitle, input, archive))
        App.setScreen(ArchiveScreen(archive))
    }
}