package simianquant.mathbridge

import org.apache.commons.math3.special.Erf

object NormalDistribution extends NormalDistributionInterface {
  private val M_SQRT2 = math.sqrt(2)
  private val M_SQRT1_2 = 1 / math.sqrt(2)

  override final def cdf(x: Double): Double = 0.5 * Erf.erfc(-x * M_SQRT1_2)

  override final def quantile(x: Double): Double = -M_SQRT2 * Erf.erfcInv(2 * x)

}