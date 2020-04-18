object Settings {
  object versions {
    val commonsMath: String = "3.6.1"
    val project: String = "0.4.0-SNAPSHOT"
    val scala: String = "2.13.1"
    val scalatest: String = "3.1.1"
    val scalacheck: String = "1.14.3"
  }

  def propConstants(factor: Int): String = s"""|package simianquant.test.mathbridge
                                               | 
                                               |object TestConstants {
                                               |  final val IntegerPowerRunCount = ${10000000 / factor}
                                               |}""".stripMargin
}
