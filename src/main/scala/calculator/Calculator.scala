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
    ???
    // val state: Map[String, Signal[Double]] =
    //   ???
    //   Map(
    //     "a" -> Signal.Var(1.0),
    //     "b" -> Signal.Var(0.0),
    //     "c" -> Signal.Var(0.0),
    //     "d" -> Signal.Var(0.0),
    //     "e" -> Signal.Var(0.0),
    //     "f" -> Signal.Var(0.0),
    //     "g" -> Signal.Var(0.0),
    //     "h" -> Signal.Var(0.0),
    //     "i" -> Signal.Var(0.0),
    //     "j" -> Signal.Var(0.0)
    //   )

    // def checkDependencies(
    //     key: String,
    //     s: Signal[Expr]
    // ) =
    //   Signal {
    //     val cExp = s()
    //     cExp match
    //       case Ref(name) if key == name =>
    //         val cState: Signal[Double] = state(name)
    //         println(s" REF => ${cState.currentValue}")
    //         // cState() = Double.NaN
    //       case _ => 
    //         val cState: Signal[Double] = state("a")
    //         println(s"???? => ${cState.currentValue}")
    //   }
    //   // val test = cExp match
    //   //   case Ref(name) if key == name => Map(key, Signal(Double.NaN))
    //   //   case Ref(name)                => ???
    //   //   case Literal(v)               => ???
    //   //   case Plus(a, b)               => ???
    //   //   case Minus(a, b)              => ???
    //   //   case Divide(a, b)             => ???
    //   //   case Times(a, b)              => ???

    // namedExpressions.foreach(checkDependencies)

    // state

  def eval(expr: Expr, references: Map[String, Signal[Expr]])(using
      Signal.Caller
  ): Double =
    val visted = Set.empty
    expr match
      case Literal(v) => v
      case Plus(a, b) => eval(a, references) + eval(b, references)
      case Minus(a, b) => eval(a, references) + eval(b, references)
      case Times(a, b) => eval(a, references) * eval(b, references)
      case Divide(a, b) => eval(a, references) / eval(b, references)
      // case Ref(name) if references.contains(name) => 
      //   val observed = references(name)() 
      //   eval(references(name), references)
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
