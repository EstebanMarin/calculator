import calculator.Signal

var xImperative = 3
var yImperative = xImperative + 2
xImperative = 5
println(yImperative)

val x = Signal.Var(3)
val y = Signal(x() + 2)
x() = 5
println(y.currentValue)

// The update does not carry over so we would have to re update the value of yImperative 
// to carry this

val num = Signal.Var(1)
val twice = Signal(num() * 2)
num() = 2
println(twice.currentValue)

var num2 = Signal.Var(1)
val twice2 = Signal(num() * 2)
num2 = Signal.Var(2)
println(twice2.currentValue)



