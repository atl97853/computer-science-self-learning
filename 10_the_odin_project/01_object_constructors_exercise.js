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
console.log(myBook.info());
