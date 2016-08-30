package info.lous.model

import scalaz._
import Scalaz._


object Implicits {

  implicit class ConvertToOption[T](t: T) {
    def optional = Option(t)
  }

}