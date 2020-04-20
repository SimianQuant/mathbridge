package simianquant.test.mathbridge

import org.scalatest.FlatSpec
import simianquant.mathbridge.SpireComplexDoubleApi._
import simianquant.mathbridge.{SpireComplexDoubleDelegate => SD}
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

  it should "pass operations compilation tests" in {
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

  it should "pass operations equivalence tests" in {
    val a = SCD(1.1, 2.2)
    val b = SCD.polar(1.6, math.Pi / 3)

    assert(a + b == SD.add(a, b))
    assert(a - b == SD.subtract(a, b))
    assert(a * 3 == SD.integerMultiply(a, 3))
    assert(a * b == SD.multiply(a, b))
    assert(a / b == SD.divide(a, b))
    assert(a ** 3 == SD.integerPower(a, 3))
    assert(a.exp == SD.exp(a))
    assert(a.sqrt == SD.sqrt(a))
    assert(a.pow(b) == SD.pow(a, b))
    assert(a.log == SD.log(a))
    assert(a.sin == SD.sin(a))
    assert(a.cos == SD.cos(a))
    assert(a.tan == SD.tan(a))
    assert(a.asin == SD.arcsin(a))
    assert(a.acos == SD.arccos(a))
    assert(a.atan == SD.arctan(a))
    assert(a.sinh == SD.sinh(a))
    assert(a.cosh == SD.cosh(a))
    assert(a.tanh == SD.tanh(a))
    assert((a - b).abs == SD.absDiff(a, b))
    assert((a - b).abs == SD.absDiff(b, a))
  }

}
