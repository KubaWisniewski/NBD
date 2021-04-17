import scala.annotation.tailrec

object Main extends App {
  val weekDays: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  println("========== Exercise 1 ==========")
  println("1a ==========")
  println(exercise1a(weekDays))
  println("1b ==========")
  println(exercise1b(weekDays))
  println("1c ==========")
  println(exercise1c(weekDays))

  println("\n========== Exercise 2 ==========")
  println("2a ==========")
  println(exercise2a(weekDays))
  println("2b ==========")
  println(exercise2b(weekDays))

  println("\n========== Exercise 3 ==========")
  println(exercise3(weekDays))

  println("\n========== Exercise 4 ==========")
  println("4a ==========")
  println(exercise4a(weekDays))
  println("4b ==========")
  println(exercise4b(weekDays))
  println("4c ==========")
  println(exercise4c(weekDays))

  println("\n========== Exercise 5 ==========")
  val products = Map("Kurczak" -> 10.0, "Makaron" -> 5.0, "Szpinak" -> 3.0)
  println(exercise5(products))

  println("\n========== Exercise 6 ==========")
  exercise6("Kurczak", 10.0, 1)

  println("\n========== Exercise 7 ==========")
  println(exercise7(products.get("Kurczak")))
  println(exercise7(products.get("Szpinak")))
  println(exercise7(products.get("Makaron")))
  println(exercise7(products.get("Woda")))

  println("\n========== Exercise 8 ==========")
  val integerList = List(-5, -2, 0, 1, 0, 2, 3, 4, 5, 0, 2, 2, 0)
  println(exercise8(integerList))

  println("\n========== Exercise 9 ==========")
  println(exercise9(integerList))

  println("\n========== Exercise 10 ==========")
  val doubleList = List(-6, -5, -4, -3.5, -2.9, -1.2, 0, 1, 5.3, 11, 12, 13.8)
  println(exercise10(doubleList))

  def exercise1a(weekDays: List[String]): String = {
    val sb: StringBuilder = new StringBuilder()
    for (day <- weekDays) {
      sb.append(s"$day,")
    }
    sb.toString()
  }

  def exercise1b(weekDays: List[String]): String = {
    val sb: StringBuilder = new StringBuilder()
    for (day <- weekDays if day.startsWith("P")) {
      sb.append(s"$day,")
    }
    sb.toString()
  }

  def exercise1c(weekDays: List[String]): String = {
    val sb: StringBuilder = new StringBuilder()
    val iterator = weekDays.iterator
    while (iterator.hasNext)
      sb.append(s"${iterator.next()},")
    sb.toString()
  }

  def exercise2a(weekDays: List[String]): String = weekDays match {
    case Nil => ""
    case head :: tail => s"${head}," + exercise2a(tail)
  }

  def exercise2b(weekDays: List[String]): String = weekDays match {
    case Nil => ""
    case head :: tail => exercise2b(tail) + s"${head},"
  }

  def exercise3(weekDays: List[String]): String = {
    @tailrec
    def rec(weekDays: List[String], weekString: String = ""): String =
      weekDays match {
        case Nil => weekString
        case head :: tail => rec(tail, s"${weekString}${head},")
      }

    rec(weekDays)
  }

  def exercise4a(weekDays: List[String]): String = weekDays.foldLeft("")(_ + "," + _)

  def exercise4b(weekDays: List[String]): String = weekDays.foldRight("")(_ + "," + _)

  def exercise4c(weekDays: List[String]): String = weekDays.filter(x => x.startsWith("P")).foldLeft("")(_ + "," + _)

  def exercise5(products: Map[String, Double]): Map[String, Double] = products.view.mapValues(a => (a * 0.9)).toMap

  def exercise6(tuple: (String, Double, Int)): Unit = println(s"${tuple._1} - ${tuple._2} - ${tuple._3}")

  def exercise7(product: Option[Double]) = product match {
    case Some(x) => x
    case None => "Brak ceny"
  }

  def exercise8(integerList: List[Int]): List[Int] = integerList match {
    case Nil => Nil
    case head :: tail => if (head == 0) exercise8(tail) else head :: exercise8(tail)
  }

  def exercise9(integerList: List[Int]): List[Int] = integerList.map(_ + 1)

  def exercise10(doubleList: List[Double]): List[Double] = doubleList.filter(_ >= -5).filter(_ <= 12).map(_.abs)
}
