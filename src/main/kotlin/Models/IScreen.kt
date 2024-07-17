package Models

interface IScreen {
    val menu: Menu
    val screenTitle: String
    val listOfCommands: MutableList<MenuCommand>
    val customInputProcess: Boolean
    var customInputMessage: String
    fun processInput(input: String)
}