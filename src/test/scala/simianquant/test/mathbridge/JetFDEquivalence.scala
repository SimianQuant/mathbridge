package simianquant.test.mathbridge

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll
import org.scalacheck.Test.Parameters
import simianquant.mathbridge.{NormalDistribution, SpireDoubleJetDelegate}
import spire.implicits._
import spire.math.{Jet, JetDim}

final class JetFDEquivalence extends Properties("Jet") {

  private val _h = 1e-6
  private implicit val _dim: JetDim = JetDim(1)

  override def overrideParameters(p: Parameters) = 
    p.withMinSuccessfulTests( TestConstants.IntegerPowerRunCount / 20).withWorkers(Runtime.getRuntime().availableProcessors())

  property("normal cdf") =  {
    forAll(Gen.choose(-5.0, 5.0)) { x =>
      val _eps1 = 1e-15
      val _eps2 = 1e-9
      val expectedReal = NormalDistribution.cdf(x)
      val expectedResidual = (NormalDistribution.cdf(x + _h) - NormalDistribution.cdf(x - _h)) / (2 * _h)

      val jet = Jet(x) + Jet.h[Double](0)
      val resJet = SpireDoubleJetDelegate.cnorm(jet)

      val realDiff = math.abs(resJet.real - expectedReal)
        // val realDiff = 11.0;
      val residualDiff = math.abs(resJet.infinitesimal(0) - expectedResidual)

      if (realDiff > _eps1) {
        println(s"real failed. diff: $realDiff x: $x, expectedReal: $expectedReal, actual: ${resJet.real}")
      } else if (residualDiff > _eps2) {
        println(s"residual failed. diff: $residualDiff x: $x, expectedResidual: $expectedResidual, actual: ${resJet
          .infinitesimal(0)}")
      }
      
      (realDiff < _eps1) && (residualDiff < _eps2)
    }
  }

  property("normal quantile") =  {
    forAll(Gen.choose(0.001, 0.999)) { x =>
      if (x < 1e-3) {
        true
      } else {

        val _eps1 = 1e-15
        val _eps2 = 5e-7

        val expectedReal = NormalDistribution.quantile(x)
        val expectedResidual = (NormalDistribution.quantile(x + _h) - NormalDistribution.quantile(x - _h)) / (2 * _h)

        val jet = Jet(x) + Jet.h[Double](0)
        val resJet = SpireDoubleJetDelegate.qnorm(jet)

        val realDiff = math.abs(resJet.real - expectedReal)
        val residualDiff = math.abs(resJet.infinitesimal(0) - expectedResidual)
        val residualQuot = math.abs(resJet.infinitesimal(0) / expectedResidual - 1)

        if (realDiff > _eps1) {
          println(s"real failed. diff: $realDiff x: $x, expectedReal: $expectedReal, actual: ${resJet.real}")
        } else if (residualDiff > _eps2 && residualQuot > _eps2) {
          println(
            s"residual failed. diff: $residualDiff quot: $residualQuot x: $x, expectedResidual: $expectedResidual, actual: ${resJet
              .infinitesimal(0)}")
        }

        (realDiff < _eps1) && ((residualDiff < _eps2) || (residualQuot < _eps2))
      }
    }
  }

}
