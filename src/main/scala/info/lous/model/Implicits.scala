package info.lous.model

import java.net.URL

import scalaz._
import Scalaz._


object Implicits {

  implicit class ConvertToOption[T](t: T) {
    def optional = Option(t)
  }


  implicit def stringToUrl(s: String):Option[URL] = {
    try {
      Some(new URL(s))
    } catch {
      case x:Throwable => None
    }
  }


}