Scala.js & Electron Skeleton
============================

This is an example of how to use Scala.js together with Electron to build native applications.

## Getting started
Get started, enter the scalajs subfolder, start sbt and launch the fastOptJS task
``` bash
cd scalajs
sbt
sbt> ~electronMain
```

Then in another shell, enter the electron-app subfolder, install javascript dependencies and launch electron
``` bash
cd electron-app
npm install
npm start
```

You should see a new window opening with the following text:
> Hello World!
>
>We are using io.js v7.4.0 and Electron 1.6.12.
>
>Hello World from Scala.js

## Main process
Sbt task `electronMain` copies the content of `fastOptJS` to form the `scala-main.js` file that will be imported into to Electron's main process.

Electron's [main process]((http://electron.atom.io/docs/tutorial/quick-start/)) is implemented by [com.example.electronapp.Main.scala](https://github.com/bchazalet/scalajs-electron-skeleton/blob/master/scalajs/src/main/scala/com/example/electronapp/Main.scala).

If for some reason, you don't want the `main.js` to come from Scala.js, see the [simple-main-js](https://github.com/bchazalet/scalajs-electron-skeleton/tree/simple-main-js) branch where the main file is exactly the one from Electron's quick start example, written in pure javascript.

## Renderer process
The javascript code loaded from within the rendered process (i.e. `index.html`) is implemented in [com.example.electronapp.Renderer.scala](https://github.com/bchazalet/scalajs-electron-skeleton/blob/master/scalajs/src/main/scala/com/example/electronapp/Renderer.scala) and uses the `JSExport` annotation to be callable from javascript and its main method is explicitly called from within `index.html`.

## Copyright
Copyright © 2016 Boris Chazalet

This work is free. You can redistribute it and/or modify it under the
terms of the Do What The Fuck You Want To Public License, Version 2,
as published by Sam Hocevar. See the COPYING file for more details.
