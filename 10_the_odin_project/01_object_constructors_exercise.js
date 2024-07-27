/**
 * Exercise: 
 * Write a constructor for making “Book” objects.
 * We will revisit this in the project at the end of this lesson. 
 * Your book objects should have the book’s title, author, the number of pages, and whether or not you have read the book.
 * 
 * Put a function into the constructor that can report the book info like so:
 * theHobbit.info(); // "The Hobbit by J.R.R. Tolkien, 295 pages, not read yet"
 */

function Book (title, author, numberPages, statusRead) {
    this.title = title;
    this.author = author;
    this.numberPages = numberPages;
    this.statusRead = statusRead;
    this.info = function() {
        return `${this.title} by ${this.author}, ${this.numberPages} pages, ${statusRead}`;
    };
}

const myBook = new Book("The Hobbit", "J.R.R Tolkien", 295, "not read yet");
// console.log(myBook.info());

// Initialize constructor functions
function Hero(name, level) {
    this.name = name;
    this.level = level;
}

function Warrior(name, level, weapon) {
Hero.call(this, name, level);

this.weapon = weapon;
}

function Healer(name, level, spell) {
Hero.call(this, name, level);

this.spell = spell;
}
  
// Link prototypes and add prototype methods
Object.setPrototypeOf(Warrior.prototype, Hero.prototype);
Object.setPrototypeOf(Healer.prototype, Hero.prototype);

Hero.prototype.greet = function () {
return `${this.name} says hello.`;
}

Warrior.prototype.attack = function () {
return `${this.name} attacks with the ${this.weapon}.`;
}

Healer.prototype.heal = function () {
return `${this.name} casts ${this.spell}.`;
}

// Initialize individual character instances
const hero1 = new Warrior('Bjorn', 1, 'axe');
const hero2 = new Healer('Kanin', 1, 'cure');


/**
 * This is the standard and recommended way to access the prototype of an object (getter and setter):
 * Object.getPrototypeOf(object)
 *  Object.setPrototypeOf(object)
 */

// const myObject = {};
// const prototype = Object.getPrototypeOf(myObject);
// console.log(prototype); // Output: Object.prototype (assuming myObject inherits from the default prototype chain)

// animal has methods
let animal = {
    walk() {
        if (!this.isSleeping) {
        console.log(`I walk`);
        }
    },
sleep() {
    this.isSleeping = true;
}
};

let rabbit = {
name: "White Rabbit",
__proto__: animal
};

// modifies rabbit.isSleeping
rabbit.sleep();

console.log(rabbit.isSleeping); // true
//   animal.sleep();
console.log(animal.isSleeping); 


