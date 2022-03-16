package joshua.sommerfeld.vintracecodingchallenge.fs

object FileReader {
    fun readJsonFileFromResources(fileName: String): String? {
        return try {
            this::class.java.classLoader.getResource("$fileName.json").readText()
        } catch (noFile: NullPointerException) {
            null
        }
    }
}
