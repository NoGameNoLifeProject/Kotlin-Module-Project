package Screens

import App
import Archives
import Models.IScreen
import Models.Menu
import Models.MenuCommand

class ArchivesScreen : IScreen {
    override val menu = Menu(this)
    override val screenTitle = "Список архивов"
    override val listOfCommands: MutableList<MenuCommand> = mutableListOf()
    override val customInputProcess = false
    override var customInputMessage = ""
    override fun processInput(input: String) {}

    init {
        listOfCommands.add(MenuCommand("Создать архив") { App.setScreen(CreateArchiveScreen())})
        Archives.getArchives().forEach {
            listOfCommands.add(MenuCommand(it.title) {App.setScreen(ArchiveScreen(it))})
        }
        listOfCommands.add(MenuCommand("Выход") { App.stop() })
    }
}