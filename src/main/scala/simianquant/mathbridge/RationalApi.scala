package simianquant.mathbridge

import spire.std.AnyInstances
import spire.syntax.AllSyntax

/** Utility type to club all imports required to use [[spire.math.Rational]]
  *
  * @author Harshad Deo
  * @since 0.2.0
  */
trait RationalApi extends AnyInstances with AllSyntax {
  type Rational = spire.math.Rational
  val Rational = spire.math.Rational
}

object RationalApi extends RationalApi
