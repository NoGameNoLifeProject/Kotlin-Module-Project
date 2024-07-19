package Models

import center
import java.util.*

class Menu(val screen: IScreen) {
    private val scanner = Scanner(System.`in`)

    private fun printMenu() {
        println()
        println(screen.screenTitle.center(40, '='))
        screen.listOfCommands.forEachIndexed { index, command ->
            println("$index. ${command.title}")
        }
    }

    fun start() {
        var command: String
        while (true) {
            printMenu()
            if (screen.customInputProcess) println(screen.customInputMessage)
            if (!scanner.hasNextLine()) continue
            command = scanner.nextLine()
            if (!screen.customInputProcess) {
                if (Utils.isInt(command)) {
                    val choice = command.toInt()
                    if (choice < 0 || choice > screen.listOfCommands.size - 1) {
                        println("Введите число соответствующее одной из команд")
                    } else {
                        screen.listOfCommands[choice].event()
                    }
                } else {
                    println("Введите корректное число")
                }
            } else {
                screen.processInput(command)
            }
        }
    }
}