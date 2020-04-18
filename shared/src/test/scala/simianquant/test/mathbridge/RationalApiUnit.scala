package simianquant.test.mathbridge

import org.scalatest.FlatSpec

final class RationalApiUnit extends FlatSpec {

  it should "pass compilation tests" in {
    import simianquant.mathbridge.RationalApi._

    assertCompiles("""val a: Rational = 1""")
    assertCompiles("""val a: Rational = 1.2""")
    assertCompiles("""val a: Rational = 1.2f""")
    assertCompiles("""val a: Rational = 1L""")
    assertCompiles("""Rational("3/4")""")

    assertCompiles("""val a = Rational(1)""")
    assertCompiles("""val a = Rational(1.2)""")
    assertCompiles("""val a = Rational(1.2f)""")
    assertCompiles("""val a = Rational(1L)""")
    assertCompiles("""val a = Rational(2, 3)""")
    assertCompiles("""val a = Rational(2, 3L)""")

    assertTypeError("""val a: Rational = "foo" """)
  }

  it should "pass value equivalence unit" in {
    val v1 = simianquant.mathbridge.RationalApi.Rational(2, 3)
    val v2 = spire.math.Rational(2, 3)
    assert(v1 == v2)
  }

}
