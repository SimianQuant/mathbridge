package simianquant.test.mathbridge

import simianquant.mathbridge.IntegerPower
import simianquant.mathbridge.support.Strings
import org.scalatest.flatspec.AnyFlatSpec

final class IntegerPowerIntegerUnit extends AnyFlatSpec {

  it should "pass power 0 tests" in {
    assert(
      intercept[IllegalArgumentException](IntegerPower.integerPower(0, -5)).getMessage == Strings.NegativePowerZero
    )
    assert(
      intercept[IllegalArgumentException](IntegerPower.integerPower(0, -4)).getMessage == Strings.NegativePowerZero
    )
    assert(
      intercept[IllegalArgumentException](IntegerPower.integerPower(0, -3)).getMessage == Strings.NegativePowerZero
    )
    assert(
      intercept[IllegalArgumentException](IntegerPower.integerPower(0, -2)).getMessage == Strings.NegativePowerZero
    )
    assert(
      intercept[IllegalArgumentException](IntegerPower.integerPower(0, -1)).getMessage == Strings.NegativePowerZero
    )
    assert(intercept[IllegalArgumentException](IntegerPower.integerPower(0, 0)).getMessage == Strings.PowerZeroZero)
    assert(IntegerPower.integerPower(0, 1) == 0)
    assert(IntegerPower.integerPower(0, 2) == 0)
    assert(IntegerPower.integerPower(0, 3) == 0)
    assert(IntegerPower.integerPower(0, 4) == 0)
    assert(IntegerPower.integerPower(0, 5) == 0)
  }

  it should "pass power 1 tests" in {
    assert(IntegerPower.integerPower(1, -5) == 1)
    assert(IntegerPower.integerPower(1, -4) == 1)
    assert(IntegerPower.integerPower(1, -3) == 1)
    assert(IntegerPower.integerPower(1, -2) == 1)
    assert(IntegerPower.integerPower(1, -1) == 1)
    assert(IntegerPower.integerPower(1, 0) == 1)
    assert(IntegerPower.integerPower(1, 1) == 1)
    assert(IntegerPower.integerPower(1, 2) == 1)
    assert(IntegerPower.integerPower(1, 3) == 1)
    assert(IntegerPower.integerPower(1, 4) == 1)
    assert(IntegerPower.integerPower(1, 5) == 1)
  }

  it should "pass power -1 tests" in {
    assert(IntegerPower.integerPower(-1, -5) == -1)
    assert(IntegerPower.integerPower(-1, -4) == 1)
    assert(IntegerPower.integerPower(-1, -3) == -1)
    assert(IntegerPower.integerPower(-1, -2) == 1)
    assert(IntegerPower.integerPower(-1, -1) == -1)
    assert(IntegerPower.integerPower(-1, -0) == 1)
    assert(IntegerPower.integerPower(-1, 1) == -1)
    assert(IntegerPower.integerPower(-1, 2) == 1)
    assert(IntegerPower.integerPower(-1, 3) == -1)
    assert(IntegerPower.integerPower(-1, 4) == 1)
    assert(IntegerPower.integerPower(-1, 5) == -1)
  }

  it should "pass power 2 tests" in {
    assert(IntegerPower.integerPower(2, -5) == 0)
    assert(IntegerPower.integerPower(2, -4) == 0)
    assert(IntegerPower.integerPower(2, -3) == 0)
    assert(IntegerPower.integerPower(2, -2) == 0)
    assert(IntegerPower.integerPower(2, -1) == 0)
    assert(IntegerPower.integerPower(2, 0) == 1)
    assert(IntegerPower.integerPower(2, 1) == 2)
    assert(IntegerPower.integerPower(2, 2) == 4)
    assert(IntegerPower.integerPower(2, 3) == 8)
    assert(IntegerPower.integerPower(2, 4) == 16)
    assert(IntegerPower.integerPower(2, 5) == 32)
  }

  it should "pass power -2 tests" in {
    assert(IntegerPower.integerPower(-2, -5) == 0)
    assert(IntegerPower.integerPower(-2, -4) == 0)
    assert(IntegerPower.integerPower(-2, -3) == 0)
    assert(IntegerPower.integerPower(-2, -2) == 0)
    assert(IntegerPower.integerPower(-2, -1) == 0)
    assert(IntegerPower.integerPower(-2, 0) == 1)
    assert(IntegerPower.integerPower(-2, 1) == -2)
    assert(IntegerPower.integerPower(-2, 2) == 4)
    assert(IntegerPower.integerPower(-2, 3) == -8)
    assert(IntegerPower.integerPower(-2, 4) == 16)
    assert(IntegerPower.integerPower(-2, 5) == -32)
  }

  it should "pass power 3 tests" in {
    assert(IntegerPower.integerPower(3, -5) == 0)
    assert(IntegerPower.integerPower(3, -4) == 0)
    assert(IntegerPower.integerPower(3, -3) == 0)
    assert(IntegerPower.integerPower(3, -2) == 0)
    assert(IntegerPower.integerPower(3, -1) == 0)
    assert(IntegerPower.integerPower(3, 0) == 1)
    assert(IntegerPower.integerPower(3, 1) == 3)
    assert(IntegerPower.integerPower(3, 2) == 9)
    assert(IntegerPower.integerPower(3, 3) == 27)
    assert(IntegerPower.integerPower(3, 4) == 81)
    assert(IntegerPower.integerPower(3, 5) == 243)
  }

  it should "pass power -3 tests" in {
    assert(IntegerPower.integerPower(-3, -5) == 0)
    assert(IntegerPower.integerPower(-3, -4) == 0)
    assert(IntegerPower.integerPower(-3, -3) == 0)
    assert(IntegerPower.integerPower(-3, -2) == 0)
    assert(IntegerPower.integerPower(-3, -1) == 0)
    assert(IntegerPower.integerPower(-3, 0) == 1)
    assert(IntegerPower.integerPower(-3, 1) == -3)
    assert(IntegerPower.integerPower(-3, 2) == 9)
    assert(IntegerPower.integerPower(-3, 3) == -27)
    assert(IntegerPower.integerPower(-3, 4) == 81)
    assert(IntegerPower.integerPower(-3, 5) == -243)
  }

}
