package simianquant.mathbridge

object NormalDistribution {
  private final val sqrt2 = math.sqrt(2)

  def cdf(x: Double): Double = (1.0 - MathJSFacade.erf(-x / sqrt2)) / 2.0

}
