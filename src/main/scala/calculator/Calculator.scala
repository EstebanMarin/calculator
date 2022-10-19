package calculator

enum Expr:
  case Literal(v: Double)
  case Ref(name: String)
  case Plus(a: Expr, b: Expr)
  case Minus(a: Expr, b: Expr)
  case Times(a: Expr, b: Expr)
  case Divide(a: Expr, b: Expr)

object Calculator extends CalculatorInterface:
  import Expr.*

  def computeValues(
      namedExpressions: Map[String, Signal[Expr]]
  ): Map[String, Signal[Double]] =
    def checkDependencies(
        key: String,
        s: Signal[Expr]
    ): Map[String, Signal[Double]] =
      val cExp = s.currentValue
      // val test = cExp match
      //   case Ref(name) if key == name => Map(key, Signal(Double.NaN))
      //   case Ref(name)                => ???
      //   case Literal(v)               => ???
      //   case Plus(a, b)               => ???
      //   case Minus(a, b)              => ???
      //   case Divide(a, b)             => ???
      //   case Times(a, b)              => ???
      val test = namedExpressions.map(checkDependencies)
      Map("a" -> Signal(2.0))

    ???

  def eval(expr: Expr, references: Map[String, Signal[Expr]])(using
      Signal.Caller
  ): Double =
    ???

  /** Get the Expr for a referenced variables. If the variable is not known,
    * returns a literal NaN.
    */
  private def getReferenceExpr(
      name: String,
      references: Map[String, Signal[Expr]]
  )(using Signal.Caller): Expr =
    references
      .get(name)
      .fold[Expr] {
        Literal(Double.NaN)
      } { exprSignal =>
        exprSignal()
      }
