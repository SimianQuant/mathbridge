package simianquant.mathbridge

import spire.algebra._
import spire.math.Complex

/** Compatibility layer, to speed up compilation of functions of spire complex numbers

  * @author Harshad Deo
  * @since 0.1.3
  */
trait SpireComplexDoubleDelegate extends Serializable {
  private final val (fld, sg, nr, tr): (Field[Double], Signed[Double], NRoot[Double], Trig[Double]) = {
    import spire.implicits._
    (implicitly[Field[Double]], implicitly[Signed[Double]], implicitly[NRoot[Double]], implicitly[Trig[Double]])
  }
  def add(lhs: Complex[Double], rhs: Complex[Double]): Complex[Double] = lhs.+(rhs)(fld)
  def subtract(lhs: Complex[Double], rhs: Complex[Double]): Complex[Double] = lhs.-(rhs)(fld)
  def integerMultiply(lhs: Complex[Double], rhs: Int): Complex[Double] = lhs.*(rhs)(fld)
  def multiply(lhs: Complex[Double], rhs: Complex[Double]): Complex[Double] = lhs.*(rhs)(fld)
  def divide(lhs: Complex[Double], rhs: Complex[Double]): Complex[Double] = lhs./(rhs)(fld, sg)
  def integerPower(base: Complex[Double], pow: Int): Complex[Double] = base.**(pow)(fld, nr, sg, tr)
  def exp(arg: Complex[Double]): Complex[Double] = arg.exp(fld, tr)
  def sqrt(arg: Complex[Double]): Complex[Double] = arg.sqrt(fld, nr, sg)
  def pow(base: Complex[Double], exp: Complex[Double]): Complex[Double] = base.**(exp)(fld, nr, sg, tr)
  def log(arg: Complex[Double]): Complex[Double] = arg.log(fld, nr, tr, sg)
  def sin(arg: Complex[Double]): Complex[Double] = arg.sin(fld, tr)
  def cos(arg: Complex[Double]): Complex[Double] = arg.cos(fld, tr)
  def tan(arg: Complex[Double]): Complex[Double] = arg.tan(fld, tr)
  def arcsin(arg: Complex[Double]): Complex[Double] = arg.asin(fld, nr, tr, sg)
  def arccos(arg: Complex[Double]): Complex[Double] = arg.acos(fld, nr, tr, sg)
  def arctan(arg: Complex[Double]): Complex[Double] = arg.atan(fld, nr, tr, sg)
  def sinh(arg: Complex[Double]): Complex[Double] = arg.sin(fld, tr)
  def cosh(arg: Complex[Double]): Complex[Double] = arg.cos(fld, tr)
  def tanh(arg: Complex[Double]): Complex[Double] = arg.tan(fld, tr)
  def absDiff(arg1: Complex[Double], arg2: Complex[Double]): Double = subtract(arg1, arg2).abs(fld, nr, sg)
}

object SpireComplexDoubleDelegate extends SpireComplexDoubleDelegate