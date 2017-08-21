package io.atom.electron

import scala.scalajs.js
import js.annotation.JSGlobal

/**
 * See http://electron.atom.io/docs/v0.30.0/api/process/
 */
@js.native
@JSGlobal("process")
object Process extends js.Object {

  def platform: String = js.native

}
