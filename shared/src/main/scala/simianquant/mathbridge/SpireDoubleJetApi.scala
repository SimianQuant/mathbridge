package simianquant.mathbridge

import language.implicitConversions
import spire.math.{Jet, Numeric}
import spire.std.AnyInstances
import spire.syntax.AllSyntax

/** Utility trait to club all the imports required to use [[spire.math.Jet]]
  *
  * @author Harshad Deo
  */
trait SpireDoubleJetApi extends AnyInstances with AllSyntax with SpireDoubleJetDelegate {
  type SpireDoubleJet = spire.math.Jet[Double]
  type SDJ = SpireDoubleJet

  type JetDim = spire.math.JetDim
  val JetDim = spire.math.JetDim

  /**Forwards the calls to the method on the generic object. Simplifies the API for cases where the users don't
    * case about abstracting over the jet field
    *
    * @author Harshad Deo
    * @since 0.2.0
    */
  object SpireDoubleJet {
    def zero(implicit dim: JetDim): SpireDoubleJet = Jet.zero
    def one(implicit dim: JetDim): SpireDoubleJet = Jet.one
    def apply[A](real: A)(implicit nr: Numeric[A], dim: JetDim): SpireDoubleJet = Jet(nr.toDouble(real))
    def apply[A](real: A, k: Int)(implicit nr: Numeric[A], dim: JetDim): SpireDoubleJet = Jet(nr.toDouble(real), k)
    def apply[A, B](real: A, infinitesimal: Array[B])(implicit ev0: Numeric[A], ev1: Numeric[B]): SpireDoubleJet = {
      val infConv = new Array[Double](infinitesimal.length)
      var ctr = 0
      while (ctr < infConv.length) {
        infConv(ctr) = ev1.toDouble(infinitesimal(ctr))
        ctr += 1
      }
      new SpireDoubleJet(ev0.toDouble(real), infConv)
    }
  }

  implicit def numeric2SpireDoubleJet[A](real: A)(implicit nr: Numeric[A], dim: JetDim): SpireDoubleJet =
    SpireDoubleJet(real)

  val SDJ = SpireDoubleJet
}

object SpireDoubleJetApi extends SpireDoubleJetApi
