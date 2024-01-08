function add(x) {
    console.log('the function was assigned')
    return (y) => {
        return x + y
    }
}

const addFive = add(0)
const addTen = add(5)
