package ch.unic.eitherandfriends.assignments._1

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

final case class Employee()
final case class Diploma()

object OptionAssignment extends App {
  val employees: List[Employee] = ???

  def universityOfBoss(employee: Employee) = ???

  employees
    .map(e => universityOfBoss(e))
    .foreach(println)
}
