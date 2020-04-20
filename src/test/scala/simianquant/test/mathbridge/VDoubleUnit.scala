package simianquant.test.mathbridge

import org.scalatest.flatspec.AnyFlatSpec
import simianquant.mathbridge.{VDoubleFixed, VDoubleRepeating}

final class VDoubleUnit extends AnyFlatSpec {

  it should "pass construction tests" in {
    val vdr = VDoubleRepeating(math.Pi)
    assert(vdr.size == Int.MaxValue)

    val arr = Array(1, 2, 3.0)
    val vdf1 = VDoubleFixed(arr)
    val vdf2 = VDoubleFixed.unsafe(arr)

    assert(vdf1.size == 3)
    assert(vdf2.size == 3)

    arr(0) = -1
    assert(vdf1.applyUnsafe(0) == 1)
    assert(vdf2.applyUnsafe(0) == -1)
  }

  it should "pass access tests" in {
    val vdr = VDoubleRepeating(math.Pi)
    assert(vdr(10000) == Some(math.Pi))
    assert(vdr(Int.MaxValue) == None)
    assert(vdr(-2) == None)

    val vdf = VDoubleFixed(Array(1, 2, 3))
    assert(vdf(0) == Some(1))
    assert(vdf(1) == Some(2))
    assert(vdf(2) == Some(3))
    assert(vdf(3) == None)
    assert(vdf(-1) == None)
    assert(vdf.applyUnsafe(0) == 1)
    assert(vdf.applyUnsafe(1) == 2)
    assert(vdf.applyUnsafe(2) == 3)

    assertThrows[IndexOutOfBoundsException] {
      vdf.applyUnsafe(4)
    }
    assertThrows[IndexOutOfBoundsException] {
      vdf.applyUnsafe(-2)
    }
  }

  it should "pass toString test" in {
    val arr = Array(1, 2, 3, 4.0)
    val vdf = VDoubleFixed(arr)

    val expected = s"VDoubleFixed(${arr.mkString(", ")})"
    val actual = vdf.toString

    assert(expected == actual)
  }

  it should "pass equality and hashCode tests" in {
    val vdr = VDoubleRepeating(math.Pi)

    val arr1 = Array(1.2, 2.3, math.Pi)
    val vdf1 = VDoubleFixed(arr1)
    assert(vdf1 == vdf1)
    assert(vdf1 != arr1)
    assert(vdf1 != vdr)

    val vdf2 = VDoubleFixed.unsafe(arr1)
    assert(vdf1.## == vdf2.##)
    assert(vdf1 == vdf2)

    val vdf3 = VDoubleFixed(Array(1.2, 3.4, math.Pi, math.E)) // different length
    assert(vdf1 != vdf3)

    val vdf4 = VDoubleFixed(Array(1.2, 3.4, math.Pi)) // different elements
    assert(vdf1 != vdf4)
  }

}
