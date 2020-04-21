# Mathbridge

[![Build Status](https://travis-ci.org/SimianQuant/mathbridge.svg?branch=master)](https://travis-ci.org/SimianQuant/mathbridge)
[![Build status](https://ci.appveyor.com/api/projects/status/63k3tyaijgob1o63?svg=true)](https://ci.appveyor.com/project/harshad-deo/mathbridge)
[![Coverage Status](https://coveralls.io/repos/github/SimianQuant/mathbridge/badge.svg?branch=master)](https://coveralls.io/github/SimianQuant/mathbridge?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.simianquant/mathbridge_2.13/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.simianquant/mathbridge_2.13)
[![Scaladoc](http://javadoc-badge.appspot.com/com.simianquant/mathbridge_2.13.svg?label=scaladoc)](http://javadoc-badge.appspot.com/com.simianquant/mathbridge_2.13) 
[![Join the chat at https://gitter.im/SimianQuant/mathbridge](https://badges.gitter.im/SimianQuant/mathbridge.svg)](https://gitter.im/SimianQuant/mathbridge?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Mathbridge adds a thin wrapper over open source mathematical libraries, that aims to bridge the deficiencies in each. As such, 

1. It provides default implementations for the mathematical operators supported by the SimianQuant library
1. It patches over errors in open source implementations of certain functions (e.g. floor of `spire.math.Jet`)
1. It provides single line imports to use `spire` types

## To Use

Add the following line to your `build.sbt` file:

```scala
libraryDependencies += "com.simianquant" %% "mathbridge" % "0.4.0" // scala-jvm
```