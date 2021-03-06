package com.example.electronapp

import scala.scalajs.js
import io.atom.electron._
import scala.scalajs.js.timers._
import js.annotation._

@JSExportTopLevel("Main")
object Main {

  @JSExport
  def main(__dirname: String): Unit = {

    val electron = ElectronModule
    val app = electron.app // Module to control application life.

    // Keep a global reference of the window object, if you don't, the window will
    // be closed automatically when the JavaScript object is GCed.
    var mainWindow: BrowserWindow = null;

    // Quit when all windows are closed.
    app.on("window-all-closed", { () =>
      // On OS X it is common for applications and their menu bar
      // to stay active until the user quits explicitly with Cmd + Q
      if (Process.platform != "darwin") {
        app.quit()
      }
    });

    // This method will be called when Electron has finished
    // initialization and is ready to create browser windows.
    app.on("ready", () => {
      // Create the browser window.
      mainWindow = BrowserWindow(width = 800, height = 600)

      // and load the index.html of the app.
      mainWindow.loadURL("file://" + __dirname + "/index.html")

      // Open the devtools.
      mainWindow.openDevTools()

      // Emitted when the window is closed.
      val _ = mainWindow.on("closed", () =>
        // Dereference the window object, usually you would store windows
        // in an array if your app supports multi windows, this is the time
        // when you should delete the corresponding element.
        mainWindow = null
      );

    });

  }
}
