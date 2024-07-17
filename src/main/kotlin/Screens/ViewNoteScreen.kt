package Screens

import App
import Models.IScreen
import Models.Menu
import Models.MenuCommand
import Models.Note

class ViewNoteScreen(val note: Note) : IScreen {
    override val menu = Menu(this)
    override val screenTitle = "Заметка \"${note.title}\""
    override val listOfCommands: MutableList<MenuCommand> = mutableListOf()
    override var customInputProcess = false
    override var customInputMessage = "Введите содержимое заметки (Оставьте поле пустым для отмены добавления текста):"

    init {
        fillCommands()
    }

    fun fillCommands() {
        listOfCommands.add(MenuCommand("Просмотреть содержимое заметки") { printContent() })
        listOfCommands.add(MenuCommand("Добавить текст к заметке") {
            listOfCommands.clear()
            customInputProcess = true
        })
        listOfCommands.add(MenuCommand("Выход") { App.setScreen(ArchiveScreen(note.archive)) })
    }

    fun printContent() {
        println("Заметка \"${note.title}\"")
        println("".padStart(20, '-'))
        println(note.content)
        println("".padStart(20, '-'))
    }

    override fun processInput(input: String) {
        if (!input.isEmpty()) {
            note.content = "${note.content}\n$input"
        }

        customInputProcess = false
        fillCommands()
    }
}