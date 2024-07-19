import Models.IScreen
import Screens.ArchivesScreen
import kotlin.system.exitProcess

class Application {
    private lateinit var currentScreen: IScreen

    fun setScreen(screen: IScreen) {
        currentScreen = screen
        currentScreen.menu.start()
    }

    fun stop() {
        exitProcess(0)
    }

    fun start() {
        setScreen(ArchivesScreen())
    }
}