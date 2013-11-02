import java.io.{InputStream, File}
import scala.io.Source

object App {

  def main(args: Array[String]) {
    val source = loadSource(getClass.getResourceAsStream("template.txt"))

    val template: Template = Template(source)

    template.keyNames foreach println
    println(template(Map(
      "name" -> "Eugene",
      "surname" -> "Levin"
    )))
    
  }



  def loadSource(file: File): String = {
    Source fromFile(file) mkString
  }

  def loadSource(stream: InputStream): String = {
    Source fromInputStream(stream) mkString
  }

}
