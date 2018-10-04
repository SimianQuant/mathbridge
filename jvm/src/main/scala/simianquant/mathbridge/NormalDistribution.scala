package simianquant.mathbridge

import org.apache.commons.math3.distribution.{NormalDistribution => ND}

object NormalDistribution extends NormalDistributionInterface {
  @SuppressWarnings(Array("org.wartremover.warts.Null"))
  private val nd = new ND(null, 0, 1)

  override final def cdf(x: Double): Double = nd.cumulativeProbability(x)

  override final def quantile(x: Double): Double = nd.inverseCumulativeProbability(x)

}