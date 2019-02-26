import groovy.time.TimeCategory

//FirstClass firstClass = new FirstClass(anyVar: "str",number: 1) // no constructor
FirstClass firstClass = new FirstClass("str", 1)

Binding bndMain = new Binding()
bndMain.setProperty("firstClass", "property")
println(bndMain.getProperty("firstClass"))

println(String instanceof Integer)

firstClass.setVar(8.9)
println(firstClass.getVar())
println(firstClass.getNumber())


//2-1

Integer getInteger(Integer var) {
    var
}

int getInt(int var) {
    var
}

println(getInteger(null))
//println(getInt(null))


//2-2,3
BigDecimal bigDecimal1 = new BigDecimal(10)
BigDecimal bigDecimal2 = new BigDecimal(10)
println("bigdecimal equals: " + (bigDecimal1 == bigDecimal2))
println("bigdecimal add: " + bigDecimal1.add(bigDecimal2))
println("bigdecimal divide: " + bigDecimal1.divide(bigDecimal2))
println("bigdecimal mult: " + bigDecimal1.multiply(bigDecimal2))


//2-4
def var = 10
println(var.getClass().getName())
var = 'f'
println(var.getClass().getName())
var = 'First'
println(var.getClass().getName())
var = 10
println(var.getClass().getName())


//2-5
Date date1 = new Date(2015, 1, 28)
Date date2 = new Date(2015, 0, 31)
use(TimeCategory) {
    println(date1 - date2 - 1.months + 1.days + 1.months)
}

//3

Closure divide = { a, b -> a / b }
Closure substract = { a, b -> a - b }
Closure divideAndSubstract = { a, b, c -> substract(divide(a, b), c) }
println(divideAndSubstract(10, 5, 2))