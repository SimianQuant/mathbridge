object Settings {
  object versions {
    val commonsMath: String = "3.6.1"
    val project: String = "0.2.0"
    val scala: String = "2.12.6"
    val scalatest: String = "3.0.5"
    val scalacheck: String = "1.14.0"
    val spire: String = "0.16.0"
  }

  def propConstants(factor: Int): String = s"""|package simianquant.test.mathbridge
                                               | 
                                               |object TestConstants {
                                               |  final val IntegerPowerRunCount = ${10000000 / factor}
                                               |}""".stripMargin
}
