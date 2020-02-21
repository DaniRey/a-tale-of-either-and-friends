# A tale of Either and friends
A workshop on the Scala features, which made the difference for MySwitzerland.com

## workshop description
Have you ever wondered what is needed to gather all touristic information of an entire country? Or do you want to give your head a break while glancing at some beautiful pictures from Switzerland? This workshop is made for you. I will introduce you to the problems we had to tackle for the relaunch of www.myswitzerland.com and which solutions we tried.

You will learn about event-carried state transfer and idempotency. Challenges when mixing functional and object-oriented programming. Tasks for which functional programming was a natural match and which Scala features made the difference for our project. For each of those Scala features we will have solve exercises, partially as a group and partially everyone on there own. Last but not least, we will talk about why Either is such beautiful construct, that I devoted the title of this workshop to it.

## workshop requirements
Please checkout this repository and make sure you can successfully run `sbt compile` on it.
Very basic Scala knowhow is sufficient to attend this workshop. I will start with the basics for all assignements. For the faster or more experienced attendees, I have additional assignements, like building a "distributed" consensus algorithm using a centralized database and implementing an assignement with "given/using" in Dotty (Scala 3), instead of implicits from Scala 2.

## assignements
### structures and composition
#### Option
#### Either
#### For-comprehensions
#### sequence - List[Either] to Either[List]
### advanced (instead/after structures)
#### Building a "distributed" consensus algorithm using a centralized database
### implicits
#### build your own abstraction on Play-Json
### advanced (instead/after implicits)
#### update your Scala 2.0 solution to Dotty/Scala 3.0
#### send and Receive messages over RabbitMQ
