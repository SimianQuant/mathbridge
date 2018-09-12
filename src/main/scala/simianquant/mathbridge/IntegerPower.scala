package simianquant.mathbridge

import support.Strings

object IntegerPower {

  /** Performs fast integer power for floats
    *
    * @author Harshad Deo
    * @since 0.3.1
    */
  @SuppressWarnings(Array("org.wartremover.warts.Equals", "org.wartremover.warts.Throw"))
  def integerPower(v: Int, pow: Int): Int = {
    if (pow == 2) v * v
    else if (pow == 3) v * v * v
    else if (pow > 0) {
      var acc = 1
      var powCtr = pow
      var vacc = v
      while (powCtr > 0) {
        if ((powCtr & 1) == 1) {
          acc *= vacc
        }
        vacc *= vacc
        powCtr >>>= 1
      }
      acc
    } else if (v == 0) {
      if (pow < 0) {
        throw new IllegalArgumentException(Strings.NegativePowerZero)
      } else {
        throw new IllegalArgumentException(Strings.PowerZeroZero)
      }
    } else if (v == 1) {
      1
    } else if (v == -1) {
      if (pow % 2 == 0) 1 else -1
    } else if (pow == 0) {
      1
    } else {
      0
    }
  }

  /** Performs fast integer power for floats
    *
    * @author Harshad Deo
    * @since 0.1.4
    */
  @SuppressWarnings(Array("org.wartremover.warts.Equals"))
  def floatPower(v: Float, pow: Int): Float = {
    if (pow == 2) v * v
    else if (pow == 3) v * v * v
    else if (pow > 0) {
      var acc = 1.0f
      var powCtr = pow
      var vacc = v
      while (powCtr > 0) {
        if ((powCtr & 1) == 1) {
          acc *= vacc
        }
        vacc *= vacc
        powCtr >>>= 1
      }
      acc
    } else if (pow < 0) {
      1.0f / floatPower(v, -pow)
    } else if (v != 0f) {
      1.0f
    } else {
      java.lang.Float.NaN
    }
  }

  /** Performs fast integer power for doubles
    *
    * @author Harshad Deo
    * @since 0.1.4
    */
  @SuppressWarnings(Array("org.wartremover.warts.Equals"))
  def doublePower(v: Double, pow: Int): Double = {
    if (pow == 2) v * v
    else if (pow == 3) v * v * v
    else if (pow > 0) {
      var acc = 1.0
      var powCtr = pow
      var vacc = v
      while (powCtr > 0) {
        if ((powCtr & 1) == 1) {
          acc *= vacc
        }
        vacc *= vacc
        powCtr >>>= 1
      }
      acc
    } else if (pow < 0) {
      1.0 / doublePower(v, -pow)
    } else if (v != 0) {
      1.0
    } else {
      java.lang.Double.NaN
    }
  }

}
