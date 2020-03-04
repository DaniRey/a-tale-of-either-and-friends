package either.and.friends.forcomprehensions.solutions._1

import either.and.friends.forcomprehensions.Utils.printTitle

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
 * Rather use a for-comprehension
 *
 * Also try to build your own de-sugared version of the for-comprehension using
 *   - flatMap
 *   - map
 *
 * Then try to build a more descriptive output like s"$boss of $employee went to $university"
 */

final case class Employee(name: String, diploma: Option[Diploma], boss: Option[Employee])
final case class Diploma(university: String, year: Int)

object OptionAssignment extends App {
  val linda = Employee("Linda", Some(Diploma("MIT", 1995)), None)
  val jake = Employee("Jake", Some(Diploma("Boston", 1995)), Some(linda))
  val trudy = Employee("Trudy", Some(Diploma("Princeton", 1998)), Some(jake))
  val john = Employee("John", None, Some(jake))
  val james = Employee("James", None, Some(john))

  val employees: List[Employee] = jake :: trudy :: john :: james :: linda :: Nil


  def universityOfBoss(employee: Employee) =
    for {
      boss <- employee.boss
      diploma <- boss.diploma
    } yield diploma.university

  def universityOfBossDesugared(employee: Employee) =
    employee.boss
      .flatMap(_.diploma)
      .map(_.university)

  def universityOfBossDescriptive(employee: Employee) =
    for {
      boss <- employee.boss
      diploma <- boss.diploma
      university = diploma.university
    } yield s"${boss.name} the boss of ${employee.name} went to $university"

  printTitle("universityOfBoss")
  employees
    .flatMap(e => universityOfBoss(e))
    .foreach(println)

  printTitle("universityOfBossDesugared")
  employees
    .flatMap(e => universityOfBossDesugared(e))
    .foreach(println)

  printTitle("universityOfBossDescriptive")
  employees
    .flatMap(e => universityOfBossDescriptive(e))
    .foreach(println)
}
