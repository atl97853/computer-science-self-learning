// function a(x) {
//     function b(y) {
//         return x + y
//     }
//     return b
// }

// const something = a(2)
// console.log(something(3))

function operator(x, fun) {
    return fun
}

function sum(y) {
    return x + y
}

function sub(y) {
    return x - y
}

// const multi = (num) => { return x * num }
const calculator = operator(x = 5, (num) => { return x * num })
// console.log(multi)
console.log(calculator(4))

