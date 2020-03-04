/**
 * A functional programming style means
 *
 * - no mutation
 * - pure functions without side-effects
 * - functions as basic building block
 * - controlled effects
 *
 * Applying a functional programming style, when working with collections means:
 *  - avoid mutation
 *  - avoid external iteration
 *  - use transformation pipelines
 *
 * To do so, knowing the following building blocks is crucial
 */

//BAD: separate definition and initialization, which requires a var
var listVar: List[Int] = null
listVar = List(1, 2, 3,-1 ,4 ,-7 ,23)

//BAD: use mutable collections
val mutableList = scala.collection.mutable.ListBuffer.empty[Int]

mutableList += 1
mutableList += 2
mutableList += 3
mutableList += -1
mutableList += 4
mutableList += -7
mutableList += 2
mutableList += 3
mutableList

//GOOD: combine definition and initialisation
val nums = List(1, 2, 3, -1, 4, -7, 2, 3)

//GOOD: if/else is an expression
//it produces a return value and can be used like a pure function
val numsContainsEven = if (nums.exists(_ % 2 == 0)) "yes" else "no"

//GOOD: use filter to create new collection which only contains values, that match a predicate
//a predicate is a function T => Boolean
val positiveNums = nums.filter(n => n > 0)

//FACT: underscore is syntactic sugar, to replace x => x
val positiveNumsUsingUnderscore = nums.filter(_ > 0)

//GOOD: use map to take something and transform it into something else
//map takes a function T => U
//T and U can be the same type
val squared = nums.map(n => n * n)

//FACT: map is often used for projections
case class Employee(name: String, boss: Option[Employee])

val sandra = Employee("Sandra", None)
val olaf = Employee("Olaf", Some(sandra))
val dani = Employee("Dani", Some(olaf))

val team = List(sandra, dani, olaf)

val teamMemberNames = team.map(e => e.name)

//FACT: underscore may be used as syntactic sugar
val teamMemberNamesUnderscore = team.map(_.name)

//GOOD: flatMap is a combination of map and flatten
//flatMap on C[T] takes a function T => C[U]
//the function has to return elements of type the collection understands
//List for example has flatMap defined as follows
//   flatMap[B](f: A => IterableOnce[B]): List[B]
//
//
def divisibleBy(x: Int): List[Int] =
  if (x <= 1)
    List(x)
  else {
    val divisors = for {
      i <- 1 to x if x % i == 0
    } yield i
    divisors.toList
  }

val divisorsList = positiveNums.map(divisibleBy)
val divisors = positiveNums.flatMap(divisibleBy)

//FACT: more advanced combinations are possible
val namesOfBosses =
  team
    .flatMap(_.boss)
    .map(_.name)
