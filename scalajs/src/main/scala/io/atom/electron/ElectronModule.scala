package io.atom.electron

import scala.scalajs.js
import js.annotation.JSImport

@js.native
trait ElectronModule extends js.Object {

  def app: App = js.native

  def BrowserWindow: js.Dynamic = js.native
}

@js.native
@JSImport("electron", JSImport.Namespace)
object ElectronModule extends ElectronModule

