package simianquant.test.mathbridge

import org.scalacheck.Gen
import org.scalatest.prop.Checkers
import org.scalacheck.Prop.forAll
import org.scalactic.anyvals.PosInt
import org.scalatest.PropSpec
import simianquant.mathbridge.IntegerPower

/** Checks that IntegerPower is conformant with math.pow
  *
  * @author Harshad Deo
  * @since 0.1.0
  */
final class IntegerPowerParity extends PropSpec with Checkers {

  implicit override final val generatorDrivenConfig = PropertyCheckConfiguration(
    minSuccessful = TestConstants.IntegerPowerRunCount,
    workers = PosInt.from(Runtime.getRuntime().availableProcessors()).get)

  val genDoubleCases = for {
    base <- Gen.choose(-10.0, 10.0)
    pow <- Gen.choose(-10, 10)
  } yield (base, pow)

  val genFloatCases = for {
    base <- Gen.choose(-10f, 10f)
    pow <- Gen.choose(-8, 8)
  } yield (base, pow)

  property("double power parity") {
    check(
      forAll(genDoubleCases) {
        case (base, exp) if base == 0d && exp <= 0 => true
        case (base, exp) =>
          val computed = IntegerPower.doublePower(base, exp)
          val expected = math.pow(base, exp)
          if (Preconditions.doubleUndefined(computed) || Preconditions.doubleUndefined(expected)) {
            true
          } else {
            if (math.abs(expected) < 1) {
              math.abs(computed - expected) < 1e-10
            } else {
              val err = math.abs((computed - expected) / expected)
              err < 1e-10
            }
          }
      }
    )
  }

  property("float power parity") {
    check(
      forAll(genFloatCases) {
        case (base, exp) if base == 0f && exp <= 0 => true
        case (base, exp) =>
          val computed = IntegerPower.floatPower(base, exp)
          val expected = math.pow(base, exp).toFloat
          if (Preconditions.floatUndefined(computed) || Preconditions.floatUndefined(expected)) {
            true
          } else {
            if (math.abs(expected) < 1) {
              math.abs(computed - expected) < 1e-6
            } else {
              val err = math.abs((computed - expected) / expected)
              err < 1e-6
            }

          }
      }
    )
  }

}
