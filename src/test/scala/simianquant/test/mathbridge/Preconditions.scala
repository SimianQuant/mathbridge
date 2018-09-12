package simianquant.test.mathbridge

object Preconditions {
  def doubleUndefined(d: Double): Boolean = java.lang.Double.isNaN(d) || java.lang.Double.isInfinite(d)
  def floatUndefined(f: Float): Boolean = java.lang.Float.isNaN(f) || java.lang.Float.isInfinite(f)
}