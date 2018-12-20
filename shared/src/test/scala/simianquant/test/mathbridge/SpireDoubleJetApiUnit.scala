package simianquant.test.mathbridge

import org.scalatest.FlatSpec
import simianquant.mathbridge.SpireDoubleJetApi._
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

  it should "pass operations test" in {
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

}