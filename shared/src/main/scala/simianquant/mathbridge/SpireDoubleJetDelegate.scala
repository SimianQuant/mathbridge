package simianquant.mathbridge

import reflect.ClassTag
import spire.algebra._
import spire.math.Jet

/** Compatibility layer, to speed up compilation of functions of spire jets
  *
  * @author Harshad Deo
  * @since 0.1.3
  */
trait SpireDoubleJetDelegate {

  private val _sqrt2pi = math.sqrt(2 * math.Pi)

  private val (eqd, fld, vs, ct, sg, tr, nr) = {
    import spire.implicits._
    (
      implicitly[Eq[Double]],
      implicitly[Field[Double]],
      implicitly[VectorSpace[Array[Double], Double]],
      implicitly[ClassTag[Double]],
      implicitly[Signed[Double]],
      implicitly[Trig[Double]],
      implicitly[NRoot[Double]])
  }

  final def add(a: Jet[Double], b: Jet[Double]): Jet[Double] = a.+(b)(fld, vs)
  final def subtract(a: Jet[Double], b: Jet[Double]): Jet[Double] = a.-(b)(fld, vs)
  final def integerMultiply(a: Jet[Double], b: Int): Jet[Double] = a.*(b)(fld, vs)
  final def multiply(a: Jet[Double], b: Jet[Double]): Jet[Double] = a.*(b)(fld, vs)
  final def divide(a: Jet[Double], b: Jet[Double]): Jet[Double] = a./(b)(fld, vs)
  final def integerPower(base: Jet[Double], i: Int): Jet[Double] = base.**(i)(eqd, fld, vs)
  final def pow(base: Jet[Double], arg: Jet[Double]): Jet[Double] = base.**(arg)(ct, eqd, fld, sg, tr, vs)
  final def exp(arg: Jet[Double]): Jet[Double] = arg.exp()(fld, tr, vs)
  final def sqrt(arg: Jet[Double]): Jet[Double] = arg.sqrt()(fld, nr, vs)
  final def log(arg: Jet[Double]): Jet[Double] = arg.log()(fld, tr, vs)
  final def sin(arg: Jet[Double]): Jet[Double] = arg.sin()(fld, tr, vs)
  final def cos(arg: Jet[Double]): Jet[Double] = arg.cos()(fld, tr, vs)
  final def tan(arg: Jet[Double]): Jet[Double] = arg.tan()(fld, tr, vs)
  final def arcsin(arg: Jet[Double]): Jet[Double] = arg.asin()(fld, nr, tr, vs)
  final def arccos(arg: Jet[Double]): Jet[Double] = arg.acos()(fld, nr, tr, vs)
  final def arctan(arg: Jet[Double]): Jet[Double] = arg.atan()(fld, nr, tr, vs)
  final def sinh(arg: Jet[Double]): Jet[Double] = arg.sinh()(fld, tr, vs)
  final def cosh(arg: Jet[Double]): Jet[Double] = arg.cosh()(fld, tr, vs)
  final def tanh(arg: Jet[Double]): Jet[Double] = arg.tanh()(fld, tr, vs)

  /** The behavior deviates from the standard spire implementation to make it consistent with ceres, and with the
    * mathematical definition
    */
  final def floor(arg: Jet[Double]): Jet[Double] = {
    new Jet[Double](math.floor(arg.real), new Array[Double](arg.infinitesimal.length))
  }

  /** Calculates the cumulative normal of the jet
    *
    * @author Harshad Deo
    * @since 0.1.5
    */
  final def cnorm(arg: Jet[Double]): Jet[Double] = {
    val deriv = 0.3989422804014327 * math.exp(-arg.real * arg.real / 2)
    val inf = arg.infinitesimal
    val newInf = new Array[Double](inf.length)
    var ctr = 0
    while (ctr < newInf.length) {
      newInf(ctr) = inf(ctr) * deriv
      ctr += 1
    }
    new Jet[Double](NormalDistribution.cdf(arg.real), newInf)
  }

  /** Calculates the normal quantile of the jet
    *
    * @author Harshad Deo
    * @since 0.1.6
    */
  final def qnorm(arg: Jet[Double]): Jet[Double] = {
    val resReal = NormalDistribution.quantile(arg.real)
    val deriv = _sqrt2pi * math.exp(resReal * resReal / 2)
    val inf = arg.infinitesimal
    val newInf = new Array[Double](inf.length)
    var ctr = 0
    while (ctr < newInf.length) {
      newInf(ctr) = inf(ctr) * deriv
      ctr += 1
    }
    new Jet[Double](resReal, newInf)
  }

}

object SpireDoubleJetDelegate extends SpireDoubleJetDelegate