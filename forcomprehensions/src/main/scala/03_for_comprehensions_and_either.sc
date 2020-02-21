import scala.util.{Failure, Success, Try}

/**
 * Many of these examples where taken straight from the famous talk: "For: What is it good for?"
 * by Josh Suereth & Dick Wall
 *
 * https://www.youtube.com/watch?v=WDaw2yXAa50&t=746s
 *
 * Highly recommend to watch it!
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

//When reading/parsing data Either is very useful
type Name = String
type Age = Int
case class Person(name: String, age: Int)

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
