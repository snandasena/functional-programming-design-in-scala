package com.functional.scala.chap01

object PatternMatching {

  def show(json: JSON): String = json match {
    case JSeq(elems) => "[" + (elems map show mkString ",") + "]"
    case JObj(bindings) =>
      val assos = bindings map {
        case (key, value) => "\"" + key + "\":" + show(value)
      }
      "{" + (assos mkString ",") + "}"

    case JNum(num) => num.toString
    case JStr(str) => '\"' + str + '\"'
    case JBool(b) => b.toString
    case JNull => "null"
  }


  def main(args: Array[String]): Unit = {
    val json = JObj(Map(
      "test" -> JStr("value"),
      "testobj" -> JObj(Map(
        "key1" -> JNum(1)
      ))
    ))

    println(show(json))

    // a function example
    val f: String => String = {
      case "ping" => "pong"
    }

    println(f("ping"))

    val pf: PartialFunction[String, String] = {
      case "ping" => "pong"
    }

    println(pf.isDefinedAt("ping"))
    println(pf.isDefinedAt("test"))
  }
}
