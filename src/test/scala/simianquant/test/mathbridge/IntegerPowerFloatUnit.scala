package simianquant.test.mathbridge

import simianquant.mathbridge.IntegerPower
import org.scalatest.flatspec.AnyFlatSpec

final class IntegerPowerFloatUnit extends AnyFlatSpec {

  it should "pass power 0 tests" in {
    assert(java.lang.Float.isInfinite(IntegerPower.floatPower(0, -5)))
    assert(java.lang.Float.isInfinite(IntegerPower.floatPower(0, -4)))
    assert(java.lang.Float.isInfinite(IntegerPower.floatPower(0, -3)))
    assert(java.lang.Float.isInfinite(IntegerPower.floatPower(0, -2)))
    assert(java.lang.Float.isInfinite(IntegerPower.floatPower(0, -1)))
    assert(java.lang.Float.isNaN(IntegerPower.floatPower(0, 0)))
    assert(IntegerPower.floatPower(0, 1) == 0)
    assert(IntegerPower.floatPower(0, 2) == 0)
    assert(IntegerPower.floatPower(0, 3) == 0)
    assert(IntegerPower.floatPower(0, 4) == 0)
    assert(IntegerPower.floatPower(0, 5) == 0)
  }

  it should "pass power 1 tests" in {
    assert(IntegerPower.floatPower(1, -5) == 1f)
    assert(IntegerPower.floatPower(1, -4) == 1f)
    assert(IntegerPower.floatPower(1, -3) == 1f)
    assert(IntegerPower.floatPower(1, -2) == 1f)
    assert(IntegerPower.floatPower(1, -1) == 1f)
    assert(IntegerPower.floatPower(1, 0) == 1f)
    assert(IntegerPower.floatPower(1, 1) == 1f)
    assert(IntegerPower.floatPower(1, 2) == 1f)
    assert(IntegerPower.floatPower(1, 3) == 1f)
    assert(IntegerPower.floatPower(1, 4) == 1f)
    assert(IntegerPower.floatPower(1, 5) == 1f)
  }

  it should "pass power -1 tests" in {
    assert(IntegerPower.floatPower(-1, -5) == -1f)
    assert(IntegerPower.floatPower(-1, -4) == 1f)
    assert(IntegerPower.floatPower(-1, -3) == -1f)
    assert(IntegerPower.floatPower(-1, -2) == 1f)
    assert(IntegerPower.floatPower(-1, -1) == -1f)
    assert(IntegerPower.floatPower(-1, 0) == 1f)
    assert(IntegerPower.floatPower(-1, 1) == -1f)
    assert(IntegerPower.floatPower(-1, 2) == 1f)
    assert(IntegerPower.floatPower(-1, 3) == -1f)
    assert(IntegerPower.floatPower(-1, 4) == 1f)
    assert(IntegerPower.floatPower(-1, 5) == -1f)
  }

  it should "pass power 2 tests" in {
    assert(IntegerPower.floatPower(2, -5) == 0.03125f)
    assert(IntegerPower.floatPower(2, -4) == 0.0625f)
    assert(IntegerPower.floatPower(2, -3) == 0.125f)
    assert(IntegerPower.floatPower(2, -2) == 0.25f)
    assert(IntegerPower.floatPower(2, -1) == 0.5f)
    assert(IntegerPower.floatPower(2, 0) == 1f)
    assert(IntegerPower.floatPower(2, 1) == 2f)
    assert(IntegerPower.floatPower(2, 2) == 4f)
    assert(IntegerPower.floatPower(2, 3) == 8f)
    assert(IntegerPower.floatPower(2, 4) == 16f)
    assert(IntegerPower.floatPower(2, 5) == 32f)
  }

  it should "pass power -2 tests" in {
    assert(IntegerPower.floatPower(-2, -5) == -0.03125f)
    assert(IntegerPower.floatPower(-2, -4) == 0.0625f)
    assert(IntegerPower.floatPower(-2, -3) == -0.125f)
    assert(IntegerPower.floatPower(-2, -2) == 0.25f)
    assert(IntegerPower.floatPower(-2, -1) == -0.5f)
    assert(IntegerPower.floatPower(-2, 0) == 1f)
    assert(IntegerPower.floatPower(-2, 1) == -2f)
    assert(IntegerPower.floatPower(-2, 2) == 4f)
    assert(IntegerPower.floatPower(-2, 3) == -8f)
    assert(IntegerPower.floatPower(-2, 4) == 16f)
    assert(IntegerPower.floatPower(-2, 5) == -32f)
  }

  it should "pass power 3 tests" in {
    assert(math.abs(IntegerPower.floatPower(3, -5) - 0.00411522633744856) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(3, -4) - 0.012345679012345678) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(3, -3) - 0.037037037037037035) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(3, -2) - 0.1111111111111111) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(3, -1) - 0.3333333333333333) < 1e-7)
    assert(IntegerPower.floatPower(3, 0) == 1.0f)
    assert(IntegerPower.floatPower(3, 1) == 3f)
    assert(IntegerPower.floatPower(3, 2) == 9f)
    assert(IntegerPower.floatPower(3, 3) == 27f)
    assert(IntegerPower.floatPower(3, 4) == 81f)
    assert(IntegerPower.floatPower(3, 5) == 243f)
  }

  it should "pass power -3 tests" in {
    assert(math.abs(IntegerPower.floatPower(-3, -5) + 0.00411522633744856) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(-3, -4) - 0.012345679012345678) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(-3, -3) + 0.037037037037037035) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(-3, -2) - 0.1111111111111111) < 1e-7)
    assert(math.abs(IntegerPower.floatPower(-3, -1) + 0.3333333333333333) < 1e-7)
    assert(IntegerPower.floatPower(-3, 0) == 1.0f)
    assert(IntegerPower.floatPower(-3, 1) == -3f)
    assert(IntegerPower.floatPower(-3, 2) == 9f)
    assert(IntegerPower.floatPower(-3, 3) == -27f)
    assert(IntegerPower.floatPower(-3, 4) == 81f)
    assert(IntegerPower.floatPower(-3, 5) == -243f)
  }

}
