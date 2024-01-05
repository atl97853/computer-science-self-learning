// Example 1 -------------------------------------------
function outer() {
    console.log('the function has started')
    variable = 'hello world' // takes the outer variable according to scope
    function inner() { // closure is here 
        variable = 'something' // nested functions have access to variables declared in their outer scope
        return variable
    }
    console.log(variable)
    return inner
}

let variable // creates variable
const variableTwo = outer()

console.log(variableTwo) // the first part of the function runs and it's executed but 
console.log(typeof (variableTwo))
console.log(variableTwo()) // here the inner function is returned before execution and ends the function

// Example 2 -------------------------------------------
function test(x) {
    x += 2
    console.log(x)
    function testTwo(y) { // closure is here 
        return x + y
    }
    return testTwo
}

const something = test(5)
console.log(something) // runs the function but not the inner function because the call is not finished

console.log(something(3)) // finishes exexution and takes arguments for the inner function
