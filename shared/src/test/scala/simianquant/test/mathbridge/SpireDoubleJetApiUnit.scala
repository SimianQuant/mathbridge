package simianquant.test.mathbridge

import org.scalatest.FlatSpec
import simianquant.mathbridge.SpireDoubleJetApi._
import simianquant.mathbridge.{SpireDoubleJetDelegate => SD}
import spire.math.Jet

final class SpireDoubleJetApiUnit extends FlatSpec {

  it should "pass construction failure tests" in {
    assertTypeError("val a: SpireDoubleJet = 1")
    assertTypeError("val a: SpireDoubleJet = 1.2")
    assertTypeError("val a: SpireDoubleJet = 1.3f")
    assertTypeError("val a: SpireDoubleJet = 1L")

    assertTypeError("val a: SDJ = 1")
    assertTypeError("val a: SDJ = 1.2")
    assertTypeError("val a: SDJ = 1.3f")
    assertTypeError("val a: SDJ = 1L")

    assertTypeError("SpireDoubleJet(1)")
    assertTypeError("SpireDoubleJet(1.2)")
    assertTypeError("SpireDoubleJet(1.3f)")
    assertTypeError("SpireDoubleJet(1L)")
    assertTypeError("SpireDoubleJet(1, 1)")
    assertTypeError("SpireDoubleJet(1.2, 2)")
    assertTypeError("SpireDoubleJet(1.3f, 0)")
    assertTypeError("SpireDoubleJet(1L, 3)")

    assertTypeError("SDJ(1)")
    assertTypeError("SDJ(1.2)")
    assertTypeError("SDJ(1.3f)")
    assertTypeError("SDJ(1L)")
    assertTypeError("SDJ(1, 1)")
    assertTypeError("SDJ(1.2, 2)")
    assertTypeError("SDJ(1.3f, 0)")
    assertTypeError("SDJ(1L, 3)")
    assertCompiles("SDJ(1.2, Array(1, 2, 3, 4))")
  }

  it should "pass construction success tests" in {
    implicit val _dim = JetDim(10)

    assertCompiles("val a: SpireDoubleJet = 1")
    assertCompiles("val a: SpireDoubleJet = 1.2")
    assertCompiles("val a: SpireDoubleJet = 1.3f")
    assertCompiles("val a: SpireDoubleJet = 1L")

    assertCompiles("val a: SDJ = 1")
    assertCompiles("val a: SDJ = 1.2")
    assertCompiles("val a: SDJ = 1.3f")
    assertCompiles("val a: SDJ = 1L")

    assertCompiles("SpireDoubleJet(1)")
    assertCompiles("SpireDoubleJet(1.2)")
    assertCompiles("SpireDoubleJet(1.3f)")
    assertCompiles("SpireDoubleJet(1L)")
    assertCompiles("SpireDoubleJet(1, 1)")
    assertCompiles("SpireDoubleJet(1.2, 2)")
    assertCompiles("SpireDoubleJet(1.3f, 0)")
    assertCompiles("SpireDoubleJet(1L, 3)")

    assertCompiles("SDJ(1)")
    assertCompiles("SDJ(1.2)")
    assertCompiles("SDJ(1.3f)")
    assertCompiles("SDJ(1L)")
    assertCompiles("SDJ(1, 1)")
    assertCompiles("SDJ(1.2, 2)")
    assertCompiles("SDJ(1.3f, 0)")
    assertCompiles("SDJ(1L, 3)")

    assertCompiles("SDJ(1.2, Array(1, 2, 3, 4))")

    val convInt: SDJ = 1
    val convFloat: SDJ = 1f
    val convRational: SDJ = spire.math.Rational(1)

    assert(convInt == SDJ(1.0))
    assert(convFloat == SDJ(1.0))
    assert(convRational == SDJ(1.0))
  }

  it should "pass construction equivalence tests" in {
    implicit val _dim = JetDim(5)

    assert(SDJ.zero == Jet.zero[Double])
    assert(SDJ.one == Jet.one[Double])
    assert(SDJ(1.3) == Jet(1.3))
    assert(SDJ(1.2, 4) == SDJ(1.2, 4))
    assert(SDJ(1.2, 0) == SDJ(1.2, Array(1, 0, 0, 0, 0)))
    assert(SDJ(1.2, 1) == SDJ(1.2, Array(0, 1, 0, 0, 0)))
    assert(SDJ(1.2, 2) == SDJ(1.2, Array(0, 0, 1, 0, 0)))
    assert(SDJ(1.2, 3) == SDJ(1.2, Array(0, 0, 0, 1, 0)))
  }

  it should "pass operations compilation test" in {
    implicit val _dim = JetDim(10)

    val a = SDJ(1.2, 3)
    val b = SDJ(1.9, 2)

    assertCompiles("a + b")
    assertCompiles("add(a, b)")
    assertCompiles("a - b")
    assertCompiles("subtract(a, b)")
    assertCompiles("integerMultiply(a, 4)")
    assertCompiles("a * 3")
    assertCompiles("a * b")
    assertCompiles("multiply(a, b)")
    assertCompiles("a / b")
    assertCompiles("divide(a, b)")
    assertCompiles("integerPower(a, 3)")
    assertCompiles("a ** 4")
    assertCompiles("a ** b")
    assertCompiles("pow(a, b)")
    assertCompiles("a.exp")
    assertCompiles("exp(a)")
    assertCompiles("a.sqrt")
    assertCompiles("sqrt(a)")
    assertCompiles("log(a)")
    assertCompiles("a.log")
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
    assertCompiles("a.floor")
    assertCompiles("floor(a)")
    assertCompiles("cnorm(a)")
    assertCompiles("qnorm(a)")
  }

  it should "pass operations equivalence test" in {
    implicit val _dim = JetDim(10)

    val a = SDJ(1.2, 3)
    val b = SDJ(0.9, 2)
    val c = 3.1

    assert(a + c == SD.add(a, c))
    assert(a + c == SD.add(c, a))
    assert(a + b == SD.add(a, b))
    assert(a - c == SD.subtract(a, c))
    assert(-a + c == SD.subtract(c, a))
    assert(a - b == SD.subtract(a, b))
    assert(a * 3 == SD.integerMultiply(a, 3))
    assert(a * c == SD.multiply(a, c))
    assert(a * c == SD.multiply(c, a))
    assert(a * b == SD.multiply(a, b))
    assert(a / c == SD.divide(a, c))
    assert((a ** -1) * c == SD.divide(c, a))
    assert(a / b == SD.divide(a, b))
    assert(a ** 3 == SD.integerPower(a, 3))
    assert(a ** c == SD.pow(a, c))
    assert(a.powScalarToJet(c) == SD.pow(c, a))
    assert(a ** b == SD.pow(a, b))
    assert(a.exp == SD.exp(a))
    assert(a.sqrt == SD.sqrt(a))
    assert(a.log == SD.log(a))
    assert(a.sin == SD.sin(a))
    assert(a.cos == SD.cos(a))
    assert(a.tan == SD.tan(a))
    assert(b.asin == SD.arcsin(b))
    assert(b.acos == SD.arccos(b))
    assert(a.atan == SD.arctan(a))
    assert(a.sinh == SD.sinh(a))
    assert(a.cosh == SD.cosh(a))
    assert(a.tanh == SD.tanh(a))

    assert(SD.floor(a) == SDJ(1.0))
    assert(SD.floor(b) == SDJ(0.0))
  }

}
