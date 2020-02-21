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

