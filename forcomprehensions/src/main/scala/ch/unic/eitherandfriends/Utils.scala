package ch.unic.eitherandfriends

object Utils {
  def printTitle(title: String): Unit = {
    val separator = (0 to 50).foldLeft("")((acc, _) => acc + "#")
    println()
    println(separator)
    println(s"  $title")
    println(separator)
  }
}
