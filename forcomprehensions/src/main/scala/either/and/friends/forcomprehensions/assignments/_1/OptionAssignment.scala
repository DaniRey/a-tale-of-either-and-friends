package either.and.friends.forcomprehensions.assignments._1

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

final case class Employee()
final case class Diploma()

object OptionAssignment extends App {
  val employees: List[Employee] = ???

  def universityOfBoss(employee: Employee) = ???

  printTitle("universityOfBoss")
  employees
    .map(e => universityOfBoss(e))
    .foreach(println)
}
