import scala.util.{Failure, Success, Try}

/**
 * Many of these examples where taken straight from the famous talk: "For: What is it good for?"
 * by Josh Suereth & Dick Wall
 *
 * https://www.youtube.com/watch?v=WDaw2yXAa50&t=746s
 *
 * Highly recommend to watch it!
 */

/**
 * abstract sealed class Either[+A, +B]
 * extends Product
 * with scala.Serializable
 *
 * Either represents a value of one of two possible types (a disjoint union). An instance of Either is an instance of either scala.util.Left or scala.util.Right.
 *
 * A common use of Either is as an alternative to scala.Option for dealing with possibly missing values. In this usage, scala.None is replaced with a scala.util.Left which can contain useful information. scala.util.Right takes the place of scala.Some.
 *
 * Convention dictates that Left is used for failure and Right is used for success. For example, you could use Either[String, Int] to indicate whether a received input is a String or an Int.
 */

type ParseError = String
val e1: Either[ParseError, Int] = Right(1)
val e2: Either[ParseError, Int] = Right(5)

for {
  x <- e1.right
  y <- e2.right
} yield x * y

val e3: Either[ParseError, Int] = Left("Not a Number")
val e4: Either[ParseError, Int] = Right(5)

for {
  x <- e3.right
  y <- e4.right
} yield x * y

//Either is right biased since Scala 2.12, therefore we can omit the .right
for {
  x <- e3
  y <- e4
} yield x * y

//Why does this work?

for {
  x <- e1.right //flatMap
  y <- e2.right //map
} yield x * y

//Is the same as

e1.flatMap(
  x => e2.map(
    y => x * y)
)

e3.flatMap(
  x => e4.map(
    y => x * y)
)

/**
 * abstract sealed class Either[+A, +B]
 *
 * /** Binds the given function across `Right`.
 * *
 * *  @param f The function to bind across `Right`.
 **/
 * def flatMap[A1 >: A, B1](f: B => Either[A1, B1]): Either[A1, B1] = this match {
 * case Right(b) => f(b)
 * case _        => this.asInstanceOf[Either[A1, B1]]
 * }
 *
 * /** The given function is applied if this is a `Right`.
 * *
 * *  {{{
 *  *  Right(12).map(x => "flower") // Result: Right("flower")
 *  *  Left(12).map(x => "flower")  // Result: Left(12)
 *  *  }}}
 **/
 * def map[B1](f: B => B1): Either[A, B1] = this match {
 * case Right(b) => Right(f(b))
 * case _        => this.asInstanceOf[Either[A, B1]]
 * }
 */

//Either is very useful, when reading/parsing data
type Name = String
type Age = Int

case class Person(name: Name, age: Int)

def parseName(s: String): Either[ParseError, Name] =
  if (s.isEmpty)
    Left(s"'$s' is not a valid Name")
  else
    Right(s)

def parseAge(s: String): Either[ParseError, Age] =
  Try(s.toInt) match {
    case Failure(_) => Left(s"'$s' is not a valid Age")
    case Success(age) => Right(age)
  }

def parsePerson(inputName: String, inputAge: String): Either[ParseError, Person] = {
  for {
    name <- parseName(inputName)
    age <- parseAge(inputAge)
  } yield Person(name, age)
}

parsePerson("Sally", "25")
parsePerson("", "25")
parsePerson("Sally", "twenty eight")
