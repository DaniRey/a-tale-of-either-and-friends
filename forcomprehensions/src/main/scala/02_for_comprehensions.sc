/**
 * Many of these examples where taken straight from the famous talk: "For: What is it good for?"
 * by Josh Suereth & Dick Wall
 *
 * https://www.youtube.com/watch?v=WDaw2yXAa50&t=746s
 *
 * Highly recommend to watch it!
 */

//Your fors jedi apprenticeship
//Fors are about loops
for (i <- 1 to 10) println("hello world")

for (i <- 1 to 10) println(i * i)


//Fors can make collections or options
val squares = for (i <- 1 to 10) yield (i * i)

case class TimesResult(i: Int, j: Int, mult: Int)

//everything to the right of <- is a generator
val timesTable = for {
  i <- 1 to 5
  j <- 1 to 5
} yield TimesResult(i, j, i * j)

for {
  i <- 1 to 3 //flatMap
  j <- 1 to 3 //flatMap
  k <- 1 to 3 //map
} yield i * j * k

//working with Options
val oResult = for {
  i <- Some(1)
  j <- Some(2)
  k <- Some(5)
} yield i * j * k

def intNone: Option[Int] = None
val oNoResult = for {
  i <- Some(1)
  j <- intNone
  k <- Some(5)
} yield i * j * k


//Fors can work on futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

val f1 = Future {
  Thread.sleep(10000); 6
}
val f2 = Future {
  Thread.sleep(10000); 7
}

val f3 = for {
  x <- f1
  y <- f2
} yield x * y

f3.value

Await.result(f3, 11.seconds)

