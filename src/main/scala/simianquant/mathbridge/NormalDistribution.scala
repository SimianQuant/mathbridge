package simianquant.mathbridge

import org.apache.commons.math3.special.Erf

object NormalDistribution {
  private val M_SQRT2 = math.sqrt(2)
  private val M_SQRT1_2 = 1 / math.sqrt(2)

  final def cdf(x: Double): Double = 0.5 * Erf.erfc(-x * M_SQRT1_2)

  final def quantile(x: Double): Double = -M_SQRT2 * Erf.erfcInv(2 * x)

}