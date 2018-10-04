package simianquant.mathbridge

/** Taken from https://stackoverflow.com/questions/12556685/is-there-a-javascript-implementation-of-the-inverse-error-function-akin-to-matl
  *
  * @author Harshad Deo
  * @since 0.1.6
  */
object InverseErrorFunction {
  private val a = 0.147;

  @SuppressWarnings(Array("org.wartremover.warts.Equals"))
  def apply(x: Double): Double =
    if (x == 0) {
      0.0
    } else {
      val x0 = math.log(1 - x * x);
      val x1 = x0 / a;
      val x2 = x0 / 2;
      val x3 = x2 + (2 / (math.Pi * a));
      val x4 = math.sqrt((x3 * x3) - x1);
      val x5 = math.sqrt(x4 - x3);
      x5 * math.signum(x);
    }

}
