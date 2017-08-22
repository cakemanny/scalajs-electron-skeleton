package com.example.electronapp

import scala.scalajs.js
import org.scalajs.jquery.JQueryStatic
import js.annotation.{ JSExport, JSExportTopLevel, JSImport }

@js.native
@JSImport("jquery", JSImport.Namespace)
object jQuery extends JQueryStatic

@js.native
@JSImport("fs", JSImport.Namespace)
object fs extends js.Object {
  def readdirSync(path: String): js.Array[String] = js.native
}

@JSExportTopLevel("Renderer")
object Renderer {

  @JSExport
  def main(): Unit = {
    import japgolly.scalajs.react._
    import japgolly.scalajs.react.vdom.html_<^._

    val FileListing =
      ScalaComponent.builder[Seq[String]]("File Listing")
        .render_P(filenames =>
            <.div(
              <.p("Listing the files in the '.' using node.js API:"),
              <.ul(filenames.map(name => <.li(name)): _*)))
        .build

    jQuery("body").append("<p>Hello World from Scala.js</p>")
    val filenames = listFiles(".")

    import org.scalajs.dom.document
    FileListing(filenames).renderIntoDOM(document.body)
    //display(filenames)
  }

  def display(filenames: Seq[String]) = {
    jQuery("body").append("<p>Listing the files in the '.' using node.js API:")
    jQuery("body").append("<ul>")
    filenames.foreach { filename =>
      jQuery("body").append(s"<li>$filename</li>")
    }
    jQuery("body").append("</ul></p>")
  }

  def listFiles(path: String): Seq[String] = {
    fs.readdirSync(path)
  }
}
