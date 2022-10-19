package calculator
import scala.math._

object Polynomial extends PolynomialInterface:
  def computeDelta(
      a: Signal[Double],
      b: Signal[Double],
      c: Signal[Double]
  ): Signal[Double] =
    Signal {
      val aCurrent = a.currentValue
      val bCurrent = b.currentValue
      val cCurrent = c.currentValue
      bCurrent * bCurrent - 4 * aCurrent * cCurrent
    }

  def computeSolutions(
      a: Signal[Double],
      b: Signal[Double],
      c: Signal[Double],
      delta: Signal[Double]
  ): Signal[Set[Double]] =
    ???
