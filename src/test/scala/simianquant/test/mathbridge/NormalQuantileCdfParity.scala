package simianquant.test.mathbridge

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll
import org.scalacheck.Test.Parameters
import simianquant.mathbridge.NormalDistribution

final class NormalQuantileCdfParity extends Properties("NormalQuantileCDF") {

    override def overrideParameters(p: Parameters) = 
    p.withMinSuccessfulTests(TestConstants.IntegerPowerRunCount / 10).withWorkers(Runtime.getRuntime().availableProcessors())
  private val _eps = 1e-10

  property("quantile(cdf)") = {
    forAll(Gen.choose(-5.0, 5.0)) { x =>
      val calc = NormalDistribution.quantile(NormalDistribution.cdf(x))
      val delta = math.abs(x - calc)
      delta < _eps
    }
  }

  property("cdf(quantile)") =  
    forAll(Gen.choose(_eps, 1 - _eps)) { x =>
      val calc = NormalDistribution.cdf(NormalDistribution.quantile(x))
      val delta = math.abs(x - calc)
      delta < _eps
    }
  

}
