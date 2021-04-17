object Main extends App {
  val weekDays: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  println("========== Exercise 1 ==========")
  println(exercise1("Poniedziałek"))
  println(exercise1("Wtorek"))
  println(exercise1("Środa"))
  println(exercise1("Czwartek"))
  println(exercise1("Piątek"))
  println(exercise1("Sobota"))
  println(exercise1("Niedziela"))
  println(exercise1("XXXXXX"))

  println("========== Exercise 2 ==========")
  val kontoBankowe1 = new KontoBankowe()
  val kontoBankowe2 = new KontoBankowe(20)
  println("Stan konta domyślny:" + kontoBankowe1.stanKonta)
  println("Stan konta ze stanem początkowym:" + kontoBankowe2.stanKonta)

  println("========== Exercise 3 ==========")
  println(exercise3(OsobaCase("Jan", "Xxxxx")))
  println(exercise3(OsobaCase("Yyy", "Kowalski")))
  println(exercise3(OsobaCase("Adam", "Kowal")))
  println(exercise3(OsobaCase("Xxxx", "Yyyy")))
  println(exercise3(null))

  println("========== Exercise 4 ==========")
  println(exercise4(0, x => x + 2))
  println(exercise4(2, x => x * 2))

  println("========== Exercise 5 ==========")
  val student = new Osoba with Student
  val pracownik = new Osoba("Jan", "Kowalski") with Pracownik
  val nauczyciel = new Osoba with Nauczyciel

  val student_pracownik = new Osoba with Student with Pracownik
  val pracownik_student = new Osoba with Pracownik with Student

  println(student.podatek)
  println(pracownik.podatek)
  println(nauczyciel.podatek)
  println(student_pracownik.podatek)
  println(pracownik_student.podatek)

  def exercise1(weekDay: String): String = weekDay match {
    case "Poniedziałek" => "Praca"
    case "Wtorek" => "Praca"
    case "Środa" => "Praca"
    case "Czwartek" => "Praca"
    case "Piątek" => "Praca"
    case "Sobota" => "Weekend"
    case "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  def exercise3(person: OsobaCase): String = person match {
    case OsobaCase("Jan", _) => "Witam panie Janie!"
    case OsobaCase(_, "Kowalski") => "Dzień dobry panie Kowalski"
    case OsobaCase("Adam", "Kowal") => "Hej Adam Kowal"
    case OsobaCase(_, _) => "Cześć"
    case _ => "Witamy"
  }

  def exercise4(value: Int, fun: (Int) => Int): Int = fun(fun(fun(value)))

  class KontoBankowe(private var _stanKonta: Int = 0) {
    def stanKonta: Int = _stanKonta

    def wplata(kwota: Int): Unit = _stanKonta += kwota

    def wyplata(kwota: Int): Unit = _stanKonta -= kwota
  }

  case class OsobaCase(private val imie: String, private val nazwisko: String) {}


  abstract class Osoba(private var _imie: String = "", private var _nazwisko: String = "") {
    def imie: String = _imie

    def nazwisko: String = _nazwisko

    def podatek: Double
  }

  trait Student extends Osoba {
    override def podatek: Double = 0
  }

  trait Pracownik extends Osoba {
    var pensja: Double = 1000.0;

    override def podatek: Double = 0.2 * pensja
  }

  trait Nauczyciel extends Pracownik {
    override def podatek: Double = 0.1 * pensja
  }
}
