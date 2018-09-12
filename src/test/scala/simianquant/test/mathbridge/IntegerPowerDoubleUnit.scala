package simianquant.test.mathbridge

import simianquant.mathbridge.IntegerPower
import org.scalatest.FlatSpec

final class IntegerPowerDoubleUnit extends FlatSpec {

  it should "pass power 0 tests" in {
    assert(java.lang.Double.isInfinite(IntegerPower.doublePower(0, -5)))
    assert(java.lang.Double.isInfinite(IntegerPower.doublePower(0, -4)))
    assert(java.lang.Double.isInfinite(IntegerPower.doublePower(0, -3)))
    assert(java.lang.Double.isInfinite(IntegerPower.doublePower(0, -2)))
    assert(java.lang.Double.isInfinite(IntegerPower.doublePower(0, -1)))
    assert(java.lang.Double.isNaN(IntegerPower.doublePower(0, 0)))
    assert(IntegerPower.doublePower(0, 1) == 0)
    assert(IntegerPower.doublePower(0, 2) == 0)
    assert(IntegerPower.doublePower(0, 3) == 0)
    assert(IntegerPower.doublePower(0, 4) == 0)
    assert(IntegerPower.doublePower(0, 5) == 0)
  }

  it should "pass power 1 tests" in {
    assert(IntegerPower.doublePower(1, -5) == 1)
    assert(IntegerPower.doublePower(1, -4) == 1)
    assert(IntegerPower.doublePower(1, -3) == 1)
    assert(IntegerPower.doublePower(1, -2) == 1)
    assert(IntegerPower.doublePower(1, -1) == 1)
    assert(IntegerPower.doublePower(1, 0) == 1)
    assert(IntegerPower.doublePower(1, 1) == 1)
    assert(IntegerPower.doublePower(1, 2) == 1)
    assert(IntegerPower.doublePower(1, 3) == 1)
    assert(IntegerPower.doublePower(1, 4) == 1)
    assert(IntegerPower.doublePower(1, 5) == 1)
  }

  it should "pass power -1 tests" in {
    assert(IntegerPower.doublePower(-1, -5) == -1)
    assert(IntegerPower.doublePower(-1, -4) == 1)
    assert(IntegerPower.doublePower(-1, -3) == -1)
    assert(IntegerPower.doublePower(-1, -2) == 1)
    assert(IntegerPower.doublePower(-1, -1) == -1)
    assert(IntegerPower.doublePower(-1, 0) == 1)
    assert(IntegerPower.doublePower(-1, 1) == -1)
    assert(IntegerPower.doublePower(-1, 2) == 1)
    assert(IntegerPower.doublePower(-1, 3) == -1)
    assert(IntegerPower.doublePower(-1, 4) == 1)
    assert(IntegerPower.doublePower(-1, 5) == -1)
  }

  it should "pass power 2 tests" in {
    assert(IntegerPower.doublePower(2, -5) == 0.03125)
    assert(IntegerPower.doublePower(2, -4) == 0.0625)
    assert(IntegerPower.doublePower(2, -3) == 0.125)
    assert(IntegerPower.doublePower(2, -2) == 0.25)
    assert(IntegerPower.doublePower(2, -1) == 0.5)
    assert(IntegerPower.doublePower(2, 0) == 1)
    assert(IntegerPower.doublePower(2, 1) == 2)
    assert(IntegerPower.doublePower(2, 2) == 4)
    assert(IntegerPower.doublePower(2, 3) == 8)
    assert(IntegerPower.doublePower(2, 4) == 16)
    assert(IntegerPower.doublePower(2, 5) == 32)
  }

  it should "pass power -2 tests" in {
    assert(IntegerPower.doublePower(-2, -5) == -0.03125)
    assert(IntegerPower.doublePower(-2, -4) == 0.0625)
    assert(IntegerPower.doublePower(-2, -3) == -0.125)
    assert(IntegerPower.doublePower(-2, -2) == 0.25)
    assert(IntegerPower.doublePower(-2, -1) == -0.5)
    assert(IntegerPower.doublePower(-2, 0) == 1)
    assert(IntegerPower.doublePower(-2, 1) == -2)
    assert(IntegerPower.doublePower(-2, 2) == 4)
    assert(IntegerPower.doublePower(-2, 3) == -8)
    assert(IntegerPower.doublePower(-2, 4) == 16)
    assert(IntegerPower.doublePower(-2, 5) == -32)
  }

  it should "pass power 3 tests" in {
    assert(math.abs(IntegerPower.doublePower(3, -5) - 0.00411522633744856) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(3, -4) - 0.012345679012345678) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(3, -3) - 0.037037037037037035) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(3, -2) - 0.1111111111111111) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(3, -1) - 0.3333333333333333) < 1e-7)
    assert(IntegerPower.doublePower(3, 0) == 1.0)
    assert(IntegerPower.doublePower(3, 1) == 3)
    assert(IntegerPower.doublePower(3, 2) == 9)
    assert(IntegerPower.doublePower(3, 3) == 27)
    assert(IntegerPower.doublePower(3, 4) == 81)
    assert(IntegerPower.doublePower(3, 5) == 243)
  }

  it should "pass power -3 tests" in {
    assert(math.abs(IntegerPower.doublePower(-3, -5) + 0.00411522633744856) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(-3, -4) - 0.012345679012345678) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(-3, -3) + 0.037037037037037035) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(-3, -2) - 0.1111111111111111) < 1e-7)
    assert(math.abs(IntegerPower.doublePower(-3, -1) + 0.3333333333333333) < 1e-7)
    assert(IntegerPower.doublePower(-3, 0) == 1.0)
    assert(IntegerPower.doublePower(-3, 1) == -3)
    assert(IntegerPower.doublePower(-3, 2) == 9)
    assert(IntegerPower.doublePower(-3, 3) == -27)
    assert(IntegerPower.doublePower(-3, 4) == 81)
    assert(IntegerPower.doublePower(-3, 5) == -243)
  }

}
