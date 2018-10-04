package simianquant.mathbridge

/** Base trait to ensure that platform specific implimentations have the same signature for the operations
  *
  * @author Harshad Deo
  * @since 0.1.6
  */
trait NormalDistributionInterface {

  /** Evaluates the cumulative distribution function for the argument
    *
    * @author Harshad Deo
    * @since 0.1.6
    */
  def cdf(x: Double): Double

  /** Evaluates the quantile function, i.e. the inverse cumulative distribution function, for the argument
    *
    * @author Harshad Deo
    * @since 0.1.6
    */
  def quantile(x: Double): Double

}
