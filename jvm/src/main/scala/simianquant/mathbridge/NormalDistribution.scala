package simianquant.mathbridge

import org.apache.commons.math3.distribution.{NormalDistribution => ND}

object NormalDistribution {
  @SuppressWarnings(Array("org.wartremover.warts.Null"))
  private val nd = new ND(null, 0, 1)

  def cdf(x: Double): Double = nd.cumulativeProbability(x)

}