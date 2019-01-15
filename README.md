# Mathbridge

[![Build Status](https://travis-ci.org/SimianQuant/mathbridge.svg?branch=master)](https://travis-ci.org/SimianQuant/mathbridge)
[![Build status](https://ci.appveyor.com/api/projects/status/63k3tyaijgob1o63?svg=true)](https://ci.appveyor.com/project/harshad-deo/mathbridge)
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-0.6.17.svg)](https://www.scala-js.org)

Mathbridge adds a thin wrapper over open source mathematical libraries, that aims to bridge the deficiencies in each. As such, 

1. It provides default implementations for the mathematical operators supported by the SimianQuant library
1. It patches over errors in open source implementations of certain functions (e.g. abs of `spire.math.Jet`)
1. It provides single line imports to use `spire` types
1. It provides a consistent API across JVM and JS targets for non-standard function (e.g. Cumulative Normal)