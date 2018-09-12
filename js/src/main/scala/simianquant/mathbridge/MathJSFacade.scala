package simianquant.mathbridge

import scalajs.js.annotation.JSGlobal
import scalajs.js

@js.native
@JSGlobal("math")
object MathJSFacade extends js.Object {
  def erf(x: Double): Double = js.native
}