package ch.unic.eitherandfriends.solutions._1

/**
 * Create two "case classes"
 *  - Employee
 *  - Diploma
 *
 * Every Employee has a
 *   - name
 *   - maybe a diploma
 *   - maybe a boss
 *
 * Every Diploma has
 *   - a university (name)
 *   - a year
 *
 *
 * Write a function which returns the name of the university, which the boss
 * of a given employee attended.
 *
 * Do not use
 *   - match / case
 *   - if / else
 *
 * Rather use
 *   - map
 *   - flatMap
 */

final case class Employee(name: String, diploma: Option[Diploma], boss: Option[Employee])
final case class Diploma(university: String, year: Int)

object OptionAssignment extends App {
  val jake = Employee("Jake", Some(Diploma("Boston", 1995)), None)
  val trudy = Employee("Trudy", Some(Diploma("Princeton", 1998)), Some(jake))
  val john = Employee("John", None, Some(jake))
  val james = Employee("James", None, Some(john))

  val employees: List[Employee] = jake :: trudy :: john :: james :: Nil

  def universityOfBoss(employee: Employee) =
    employee.boss
      .flatMap(_.diploma)
      .map(_.university)
      .getOrElse("No University")

  employees
    .map(e => universityOfBoss(e))
    .foreach(println)
}
