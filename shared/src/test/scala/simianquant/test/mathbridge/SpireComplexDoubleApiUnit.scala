package simianquant.test.mathbridge

import org.scalatest.FlatSpec
import simianquant.mathbridge.SpireComplexDoubleApi._
import spire.math.Complex

final class SpireComplexDoubleApiUnit extends FlatSpec {

  it should "pass construction tests" in {
    assertCompiles("val a: SpireComplexDouble = 1")
    assertCompiles("val a: SpireComplexDouble = 1.2")
    assertCompiles("val a: SpireComplexDouble = 1.4f")
    assertCompiles("val a: SpireComplexDouble = 1L")

    assertCompiles("val a: SCD = 1")
    assertCompiles("val a: SCD = 1.2")
    assertCompiles("val a: SCD = 1.4f")
    assertCompiles("val a: SCD = 1L")

    assertCompiles("SpireComplexDouble(1)")
    assertCompiles("SpireComplexDouble(1.2)")
    assertCompiles("SpireComplexDouble(1.4f)")
    assertCompiles("SpireComplexDouble(1l)")

    assertCompiles("SCD(1)")
    assertCompiles("SCD(1.2)")
    assertCompiles("SCD(1.4f)")
    assertCompiles("SCD(1l)")
  }

  it should "pass construction equivalence tests" in {
    assert(SCD.zero == Complex.zero[Double])
    assert(SCD.one == Complex.one[Double])
    assert(SCD.i == Complex.i[Double])
    assert(SCD(3.14) == Complex[Double](3.14))
    assert(SCD(1.23, 2l) == Complex[Double](1.23, 2L))
    assert(SCD.polar(1.1, math.Pi / 5) == Complex.polar[Double](1.1, math.Pi / 5))
  }

  it should "pass operations tests" in {
    val a = SCD(1.1, 2.2)
    val b = SCD.polar(1.6, math.Pi / 3)

    assertCompiles("a + b")
    assertCompiles("add(a, b)")
    assertCompiles("a - b")
    assertCompiles("subtract(a, b)")
    assertCompiles("a * 5")
    assertCompiles("integerMultiply(a, 5)")
    assertCompiles("a * b")
    assertCompiles("multiply(a, b)")
    assertCompiles("a / b")
    assertCompiles("divide(a, b)")
    assertCompiles("a ** 2")
    assertCompiles("integerPower(a, 3)")
    assertCompiles("a.exp")
    assertCompiles("exp(a)")
    assertCompiles("a.sqrt")
    assertCompiles("sqrt(a)")
    assertCompiles("a ** b")
    assertCompiles("pow(a, b)")
    assertCompiles("a.log")
    assertCompiles("log(a)")
    assertCompiles("a.sin")
    assertCompiles("sin(a)")
    assertCompiles("a.cos")
    assertCompiles("cos(a)")
    assertCompiles("a.tan")
    assertCompiles("tan(a)")
    assertCompiles("a.asin")
    assertCompiles("arcsin(a)")
    assertCompiles("a.acos")
    assertCompiles("arccos(a)")
    assertCompiles("a.atan")
    assertCompiles("arctan(a)")
    assertCompiles("a.sinh")
    assertCompiles("sinh(a)")
    assertCompiles("a.cosh")
    assertCompiles("cosh(a)")
    assertCompiles("a.tanh")
    assertCompiles("tanh(a)")
  }

}