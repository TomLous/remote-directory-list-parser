import org.scalatest.FunSuite
import info.lous.model.FileUtils._
/**
  * Created by Tom Lous on 30/08/16.
  * Copyright © 2016 Datlinq B.V..
  */



class FileSizeTest extends FunSuite{

  test("10 kb") {
    val str = "10 kb"
    val bytes = Some((10 * 1024).toLong)
    assert(str.toFileSize == bytes)
  }

  test("234 MB") {
    val str = "234 MB"
    val bytes = Some((234 * 1024 * 1024).toLong)
    assert(str.toFileSize == bytes)
  }

  test("1.3 gB") {
    val str = "1.3 gB"
    val bytes = Some((1.3 * 1024 * 1024 * 1024).toLong)
    assert(str.toFileSize == bytes)
  }

  test("2,5Tb") {
    val str = "2,5Tb"
    val bytes = Some((2.5 * 1024 * 1024 * 1024 * 1024).toLong)
    assert(str.toFileSize == bytes)
  }

  test("0.0") {
    val str = "0.0"
    val bytes = Some((0).toLong)
    assert(str.toFileSize == bytes)
  }

  test("-") {
    val str = "-"
    val bytes = None
    assert(str.toFileSize == bytes)
  }

  test("237 rb") {
    val str = "237 rb"
    val bytes = None
    assert(str.toFileSize == bytes)
  }


}
