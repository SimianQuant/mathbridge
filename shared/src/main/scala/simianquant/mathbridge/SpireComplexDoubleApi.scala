package simianquant.mathbridge

import spire.math.{Complex, Numeric}
import spire.std.AnyInstances
import spire.syntax.AllSyntax

/** Utility trait to club all the imports required to use [[spire.math.Complex]]
  *
  * @author Harshad Deo
  */
trait SpireComplexDoubleApi extends AnyInstances with AllSyntax with SpireComplexDoubleDelegate {
  type SpireComplexDouble = Complex[Double]
  type SCD = SpireComplexDouble

  /**Forwards the calls to the method on the generic object. Simplifies the API for cases where the users don't
    * case about abstracting over the complex field
    *
    * @author Harshad Deo
    * @since 0.2.0
    */
  object SpireComplexDouble {
    def i: SpireComplexDouble = Complex.i
    def zero: SpireComplexDouble = Complex.zero
    def one: SpireComplexDouble = Complex.one
    def apply[A](arg: A)(implicit ev: Numeric[A]): SpireComplexDouble = Complex(ev.toDouble(arg))
    def apply[A, B](real: A, imag: B)(implicit ev0: Numeric[A], ev1: Numeric[B]): SpireComplexDouble =
      Complex(ev0.toDouble(real), ev1.toDouble(imag))
    def polar[A, B](magnitude: A, phase: B)(implicit ev0: Numeric[A], ev1: Numeric[B]): SpireComplexDouble =
      Complex.polar(ev0.toDouble(magnitude), ev1.toDouble(phase))
  }
  val SCD = SpireComplexDouble

}

object SpireComplexDoubleApi extends SpireComplexDoubleApi
