
case class Template(template: String, lenient: Boolean = true) {

  private val KEY_PATTERN = "\\{(\\w+)\\}".r("key")

  private lazy val keys = KEY_PATTERN.findAllMatchIn(template)

  lazy val keyNames = (for(key <- keys) yield key.group("key")).toSet

  def apply(map: Map[String, String]) = {
    KEY_PATTERN.replaceAllIn(template, x => {
      val key = x.group("key")
      if (!lenient || map.contains(key)) map(key)
      else x.group(0)
    })
  }

}
