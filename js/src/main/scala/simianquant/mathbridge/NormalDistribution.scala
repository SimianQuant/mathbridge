package simianquant.mathbridge

object NormalDistribution extends NormalDistributionInterface {
  private final val sqrt2 = math.sqrt(2)

  def cdf(x: Double): Double = (1.0 - MathJSFacade.erf(-x / sqrt2)) / 2.0

  def quantile(x: Double): Double = -sqrt2 * InverseErrorFunction(1 - 2 * x)

}