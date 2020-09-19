package com.functional.scala.chap01

object CollectionsExamples {
  //
  //  abstract class MyList[+T] {
  //    def map[U](f: T => U): MyList[U] = this match {
  //      case x :: xs => f(x) :: xs.map(f)
  //      case Nil => Nil
  //    }
  //
  //    def flatMap[U](f : T => MyList[U])
  //  }

  def main(args: Array[String]): Unit = {
    val data = 1 until 10000
    var c = 0
    for {
      i <- data
      j <- 1 until i
      if (i + j) % 2 == 0
    } yield (c +=1)

    println(c)
  }
}
