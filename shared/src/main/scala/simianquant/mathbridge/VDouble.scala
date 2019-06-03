package simianquant.mathbridge

import util.hashing.MurmurHash3

/** Base trait for a wrapper over a vector/stream of doubles
  *
  * @author Harshad Deo
  * @since 0.3.0
  */
sealed trait VDouble {

  /** Length of the vector
    *
    * @author Harshad Deo
    * @since 0.3.0
    */
  def size: Int

  /** Returns the element at the index, otherwise throws an [[java.lang.IndexOutOfBoundsException]] exception.
    *
    * @author Harshad Deo
    * @since 0.3.0
    */
  def applyUnsafe(idx: Int): Double

  /** Returns the element at the index, if present
    *
    * @author Harshad Deo
    * @since 0.3.0
    */
  final def apply(idx: Int): Option[Double] = if (idx >= 0 && idx < size) Some(applyUnsafe(idx)) else None

}

/** Representation of a static stream of doubles
  *
  * @author Harshad Deo
  * @since 0.3.0
  */
case class VDoubleRepeating(arg: Double) extends VDouble {
  override final def size: Int = Int.MaxValue
  override final def applyUnsafe(idx: Int): Double = arg
}

/** Representation of a wrapper over a fixed length vector. Can only be constructed using the companion object
  *
  * @author Harshad Deo
  * @since 0.3.0
  */
final class VDoubleFixed private (private val backing: Array[Double]) extends VDouble {
  override final def size: Int = backing.length
  override final def applyUnsafe(idx: Int): Double = backing(idx)
  override final def toString: String = backing.mkString("VDoubleFixed(", ", ", ")")
  override final def hashCode: Int = MurmurHash3.arrayHash(backing)
  @SuppressWarnings(Array("org.wartremover.warts.Equals"))
  override final def equals(other: Any): Boolean = other match {
    case that: VDoubleFixed =>
      (this eq that) || (
        (this.backing.length == that.backing.length) &&
          (this.backing.sameElements(that.backing))
      )
    case _ => false
  }
}

/** Holds the constructors
  *
  * @author Harshad Deo
  * @since 0.3.0
  */
object VDoubleFixed {

  /** Constructs an instance by creating a deep copy of the argument
    *
    * @author Harshad Deo
    * @since 0.3.0
    */
  def apply(arr: Array[Double]): VDoubleFixed = {
    val backing = new Array[Double](arr.length)
    var ctr = 0
    while (ctr < arr.length) {
      backing(ctr) = arr(ctr)
      ctr += 1
    }
    new VDoubleFixed(backing)
  }

  /** Constructs an instance without creating a deep copy of the argument. Use with caution
    *
    * @author Harshad Deo
    * @since 0.3.0
    */
  def unsafe(arr: Array[Double]): VDoubleFixed = new VDoubleFixed(arr)
}
