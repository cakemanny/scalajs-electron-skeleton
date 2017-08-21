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
    jQuery("body").append("<p>Hello World from Scala.js</p>")
    val filenames = listFiles(".")
    display(filenames)
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
