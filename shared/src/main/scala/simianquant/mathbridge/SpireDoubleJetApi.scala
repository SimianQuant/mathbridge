package simianquant.mathbridge

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
  }

  val SDJ = SpireDoubleJet
}

object SpireDoubleJetApi extends SpireDoubleJetApi