package com.functional.scala.chap01

object ForQueries {

  case class Book(title: String, authors: List[String])

  val books: List[Book] = List(
    Book(
      title = "Structure and Interpretation of Computer programs",
      authors = List("Abelson, Harold", "Sussman, Gerald J.")
    ),
    Book(
      title = "Introduction to functional programming",
      authors = List("Bird, Richard", "Wadler, Phil")
    ),
    Book(
      title = "Effective java",
      authors = List("Bloch, Joshua")
    ),
    Book(
      title = "Effective java2",
      authors = List("Bloch, Joshua")
    ),
    Book(
      title = "Java puzzlers",
      authors = List("Bloch, Joshua", "Gafter, Neal")
    ),
    Book(
      title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")
    )
  )

  def main(args: Array[String]): Unit = {
    val query1 = for {
      b <- books
      a <- b.authors
      if a startsWith "Bloch,"
    } yield b.title

    println(query1)

    val query02 = for (b <- books if b.title.indexOf("Program") >= 0) yield b.title
    println(query02)

    val query03 = for {
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    }yield a1

    println(query03)
    println(query03.distinct)

  }

}
