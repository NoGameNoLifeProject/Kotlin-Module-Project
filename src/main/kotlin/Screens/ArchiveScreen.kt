package Screens

import App
import Models.Archive
import Models.IScreen
import Models.Menu
import Models.MenuCommand

class ArchiveScreen(archive: Archive) : IScreen {
    override val menu = Menu(this)
    override val screenTitle = "Список заметок для архива \"${archive.title}\""
    override val listOfCommands: MutableList<MenuCommand> = mutableListOf()
    override val customInputProcess = false
    override var customInputMessage = ""
    override fun processInput(input: String) {}

    init {
        listOfCommands.add(MenuCommand("Создать заметку") { App.setScreen(CreateNoteScreen(archive)) })
        archive.getNotes().forEach {
            listOfCommands.add(MenuCommand(it.title) { App.setScreen(ViewNoteScreen(it)) })
        }
        listOfCommands.add(MenuCommand("Выход") { App.setScreen(ArchivesScreen()) })
    }
}