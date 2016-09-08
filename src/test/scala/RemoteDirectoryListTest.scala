import org.scalatest.FunSuite
import info.lous.model._
import java.net.URL

/**
  * Created by Tom Lous on 08/09/16.
  * Copyright © 2016 Datlinq B.V..
  */
class RemoteDirectoryListTest extends FunSuite{

  test("Apache Format 1") {
    val lines = List(
      "<tr><td valign=\"top\"><img src=\"/icons/folder.gif\" alt=\"[DIR]\"></td><td><a href=\"bron/\">bron/</a></td><td align=\"right\">2015-04-23 20:08  </td><td align=\"right\">  - </td><td>&nbsp;</td></tr>",
      "<tr><td valign=\"top\"><img src=\"/icons/back.gif\" alt=\"[PARENTDIR]\"></td><td><a href=\"/\">Parent Directory</a></td><td>&nbsp;</td><td align=\"right\">  - </td><td>&nbsp;</td></tr>",
      "<tr><td valign=\"top\"><img src=\"/icons/hand.right.gif\" alt=\"[   ]\"></td><td><a href=\"README\">README</a></td><td align=\"right\">2014-12-21 22:14  </td><td align=\"right\">1.0K</td><td>&nbsp;</td></tr>"
    )

    val url = new URL("http://lous.info/test/")

    val results = lines map {
      RemoteDirectoryListItem(_ , url)
    }

    assert(results.forall(_.isInstanceOf[RemoteDirectoryListItem]))
    assert(results(0).isInstanceOf[RemoteDirectoryDirectory])
    assert(results(1) == RemoteDirectoryListEmpty)
    assert(results(2).isInstanceOf[RemoteDirectoryListItem])


  }
  /*
  val lines = List(
  "<tr><td valign=\"top\"><img src=\"/icons/folder.gif\" alt=\"[DIR]\"></td><td><a href=\"bron/\">bron/</a></td><td align=\"right\">2015-04-23 20:08  </td><td align=\"right\">  - </td><td>&nbsp;</td></tr>",
  "<tr><td valign=\"top\"><img src=\"/icons/back.gif\" alt=\"[PARENTDIR]\"></td><td><a href=\"/\">Parent Directory</a></td><td>&nbsp;</td><td align=\"right\">  - </td><td>&nbsp;</td></tr>",
  "<tr><td valign=\"top\"><img src=\"/icons/hand.right.gif\" alt=\"[   ]\"></td><td><a href=\"README\">README</a></td><td align=\"right\">2014-12-21 22:14  </td><td align=\"right\">1.0K</td><td>&nbsp;</td></tr>",
  "<A href=\"../\">../</A>",
  "<A href=\"0.1.1-SNAPSHOT/\">0.1.1-SNAPSHOT/</a>           02-Sep-2016 12:28    -",
  "<a href=\"maven-metadata.xml.md5\">maven-metadata.xml.md5</a>    02-Sep-2016 13:05  32 bytes",
  "<a HREF=\"perceptron-service_2.11-0.1.1-20160902.122851-1-sources.jar.md5\">perceptron-service_2.11-0.1.1-20160902.122851-1-sources.jar.md5</a>    02-Sep-2016 12:28  32 bytes",
  "<a href=\"perceptron-service_2.11-0.1.1-20160902.122851-1-javadoc.jar\">perceptron-service_2.11-0.1.1-20160902.122851-1-javadoc.jar</a>        02-Sep-2016 12:28  529.60 KB"
)
   */

}
