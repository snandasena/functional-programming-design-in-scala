package com.functional.scala

object TestChapterOne {

  forAll { (l1: List[Int], l2: List[Int]) =>
    l1.size + l2.size == (l1 ++ l2).size
  }

}
