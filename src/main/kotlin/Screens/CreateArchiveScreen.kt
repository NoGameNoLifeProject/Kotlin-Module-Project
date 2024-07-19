package Screens

import App
import Archives
import Models.IScreen
import Models.Menu
import Models.MenuCommand

class CreateArchiveScreen: IScreen {
    override val menu = Menu(this)
    override val screenTitle = "Создание архива"
    override val listOfCommands: MutableList<MenuCommand> = mutableListOf()
    override val customInputProcess = true
    override var customInputMessage = "Введите уникальное название архива (Оставьте поле пустым для отмены создания):"

    override fun processInput(input: String) {
        if (input.isEmpty()) {
            App.setScreen(ArchivesScreen())
        }
        if (Archives.getArchiveByTitle(input) != null){
            println("Архив с таким названием уже существует")
            return
        }
        Archives.createArchive(input)
        App.setScreen(ArchivesScreen())
    }
}