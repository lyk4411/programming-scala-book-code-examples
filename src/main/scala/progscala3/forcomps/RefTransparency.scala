// src/main/scala/progscala3/forcomps/RefTransparency.scala
package progscala3.forcomps

object RefTransparency {
  def addInts(s1: String, s2: String): Int = s1.toInt + s2.toInt

  def addInts2(s1: String, s2: String): Either[String,Int] =
    try {
      Right(s1.toInt + s2.toInt)
    } catch {
      case nfe: NumberFormatException => Left("NFE: "+nfe.getMessage)
    }

  def main(args: Array[String]): Unit = {
  	for {
  	  i <- 1 to 3
  	  j <- 1 to i
  	} assert(addInts(i.toString, j.toString) == i+j)

  	assert(addInts2("1", "2") == Right(3))
  	assert(addInts2("1", "x") == Left("NFE: For input string: \"x\""))
  	assert(addInts2("x", "2") == Left("NFE: For input string: \"x\""))
  }
}
