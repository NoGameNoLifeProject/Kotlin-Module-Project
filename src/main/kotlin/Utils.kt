object Utils {
    fun isInt(str: String): Boolean {
        return str.toIntOrNull() != null
    }
}

fun String.center(totalWidth: Int, fillChar: Char = ' '): String {
    if (this.length > totalWidth) {
        return this
    }
    val leftPadding = (totalWidth - this.length) / 2
    return fillChar.toString().repeat(leftPadding) + " $this " + fillChar.toString().repeat(totalWidth - this.length - leftPadding)
}