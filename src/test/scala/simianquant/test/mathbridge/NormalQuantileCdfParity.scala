// package simianquant.test.mathbridge

// import org.scalacheck.Gen
// import org.scalatest.prop.Configuration
// import org.scalacheck.Prop.forAll
// import org.scalactic.anyvals.PosInt
// import org.scalatest.PropSpec
// import simianquant.mathbridge.NormalDistribution

// final class NormalQuantileCdfParity extends PropSpec with Configuration {

//   implicit override final val generatorDrivenConfig = PropertyCheckConfiguration(
//     minSuccessful = TestConstants.IntegerPowerRunCount / 10,
//     workers = PosInt.from(Runtime.getRuntime().availableProcessors()).get)

//   private val _eps = 1e-10

//   property("quantile(cdf)") {
//     check(forAll(Gen.choose(-5.0, 5.0)) { x =>
//       val calc = NormalDistribution.quantile(NormalDistribution.cdf(x))
//       val delta = math.abs(x - calc)
//       delta < _eps
//     })
//   }

//   property("cdf(quantile)") {
//     check(forAll(Gen.choose(_eps, 1 - _eps)) { x =>
//       val calc = NormalDistribution.cdf(NormalDistribution.quantile(x))
//       val delta = math.abs(x - calc)
//       delta < _eps
//     })
//   }

// }
