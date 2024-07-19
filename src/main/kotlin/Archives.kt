import Models.Archive

object Archives {
    private val archives = mutableListOf<Archive>()

    fun getArchives(): List<Archive> {
        return archives
    }

    fun createArchive(title: String) {
        archives.add(Archive(title))
    }

    fun getArchiveByTitle(title: String): Archive? {
        return archives.find { it.title == title }
    }
}