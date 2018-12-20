package simianquant.test.mathbridge

import org.scalatest.FlatSpec
import simianquant.mathbridge.RationalApi._

final class RationalApiUnit extends FlatSpec {

  it should "pass compilation tests" in {
    assertCompiles("""val a: Rational = 1""")
    assertCompiles("""val a: Rational = 1.2""")
    assertCompiles("""val a: Rational = 1.2f""")
    assertCompiles("""val a: Rational = 1L""")
    assertCompiles("""Rational("3/4")""")
    assertTypeError("""val a: Rational = "foo" """)
  }

}