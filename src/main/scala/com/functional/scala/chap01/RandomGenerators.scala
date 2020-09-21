package com.functional.scala.chap01

import java.util.Random

object RandomGenerators {
  val rand = new Random

  trait Tree

  case class Inner(left: Tree, right: Tree) extends Tree

  case class Leaf(x: Int) extends Tree

  def main(args: Array[String]): Unit = {
    val integers = new Generator[Int] {
      override def generate: Int = rand.nextInt
    }
    println(integers.generate)
    val booleans = new Generator[Boolean] {
      override def generate: Boolean = integers.generate >= 0
    }
    println(booleans.generate)

    val pairs = new Generator[(Int, Int)] {
      override def generate: (Int, Int) = (integers.generate, integers.generate)
    }

    val booleans2 = for (x <- integers) yield x > 0
    println(booleans2.generate)

    println(pairs.generate)

    def leaves: Generator[Leaf] = for {
      x <- integers
    } yield Leaf(x)


    def inners: Generator[Inner] = for {
      l <- trees
      r <- trees
    } yield Inner(l, r)

    def trees: Generator[Tree] = for {
      isLeaf <- booleans
      tree <- if (isLeaf) leaves else inners
    } yield tree


    println(trees.generate)
  }


}
