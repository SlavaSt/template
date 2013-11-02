import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class AppTest extends FunSuite {

  test("just test") {
    val template = Template("hello Mr {surname} {name}")

    template.keyNames foreach println

    println(template(Map("surname" -> "Levin", "name" -> "Eugene")))
  }

}
