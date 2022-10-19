package calculator
import scala.math._

object Polynomial extends PolynomialInterface:
  def computeDelta(
      a: Signal[Double],
      b: Signal[Double],
      c: Signal[Double]
  ): Signal[Double] =
    Signal(Math.pow(b(), 2) - 4 * a() * c())

  def computeSolutions(
      a: Signal[Double],
      b: Signal[Double],
      c: Signal[Double],
      delta: Signal[Double]
  ): Signal[Set[Double]] =
    Signal {
      if delta() < 0 then Set.empty
      else Set((-b() + delta()) / (2 * a()), (-b() - delta()) / (2 * a()))
    }
