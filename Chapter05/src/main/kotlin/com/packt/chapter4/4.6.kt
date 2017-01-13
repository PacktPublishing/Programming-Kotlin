fun main(args: Array<String>) {


  val string = "a kindness of ravens"
  string.regionMatches(14, "Red Ravens", 4, 6, true)

  string.regionMatches(thisOffset = 14, other = "Red Ravens", otherOffset = 4, length = 6, ignoreCase = true)

  fun deleteFiles(filePattern: String, recursive: Boolean, ignoreCase: Boolean, deleteDirectories: Boolean): Unit {

  }

  deleteFiles("*.jpg", true, true, false)

  deleteFiles("*.jpg", recursive = true, ignoreCase = true, deleteDirectories = false)

  deleteFiles(filePattern = "*.jpg", deleteDirectories = false, ignoreCase = true, recursive = true)

  string.endsWith(suffix = "ravens", ignoreCase = true)

  string.endsWith(ignoreCase = true, suffix = "ravens")
}