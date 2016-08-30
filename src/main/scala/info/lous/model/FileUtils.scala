package info.lous.model

import scalaz._
import Scalaz._

/**
  * Created by Tom Lous on 26/08/16.
  * Copyright © 2016 Datlinq B.V..
  */


object FileUtils {

  type FileSize = Long

  implicit class FileSizeParser(s: String) {
    import info.lous.model.Implicits._

    val sizeUnits = List("", "kb", "mb", "gb","tb","pb","eb","zb","yb")

    def toFileSize:Option[FileSize] = {
      val pattern = """(\d+)([\.,](\d+))?\s*(\w+)?""".r

      try {
        val pattern(before, sep, after, unit) = s.trim

        val num:Double = List(before.optional | "0", ".", after.optional | "0").reduce({ _ + _ }).toDouble

        val idx = sizeUnits.indexOf((unit.optional | "").toLowerCase)

        if(idx < 0) None
        else (Math.pow(1024, idx) * num).toLong.some

      } catch {
        case x: Throwable => None
      }

    }


  }


}
