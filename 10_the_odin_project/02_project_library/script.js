/**
 * All of your book objects are going to be stored in an array, 
 * so add a function to the script (not the constructor) that can 
 * take user’s input and store the new book objects into an array. 
 * 
 * Write a function that loops through the array and displays each book 
 * on the page. You can display them in some sort of table, or each on their 
 * own “card”. It might help for now to manually add a few books to your array 
 * so you can see the display.
 * 
 * Add a “NEW BOOK” button that brings up a form allowing users to input the details 
 * for the new book: author, title, number of pages, whether it’s been read and anything 
 * else you might want. How you decide to display this form is up to you. For example, you may 
 * wish to have a form show in a sidebar or you may wish to explore dialogs and modals using the <dialog> tag. 
 * However you do this, you will most likely encounter an issue where submitting your form will not do what you expect 
 * it to do. That’s because the submit input tries to send the data to a server by default. This is where event.preventDefault(); 
 * will come in handy. Check out the documentation for event.preventDefault and see how you can solve this issue!
 * 
 * Add a button on each book’s display to remove the book from the library.
 * 
 * Add a button on each book’s display to change its read status.
 */

const myLibrary = [];

function Book(title, author, numberPages, statusRead) {
  this.title = title;
  this.author = author;
  this.numberPages = numberPages;
  this.statusRead = statusRead;
}

function addBookToLibrary(title, author, numberPages, statusRead) {
  myLibrary.push(new Book(title = title, author = author, numberPages = numberPages, statusRead = statusRead));
}


function loopLibrary() {
  myLibrary.forEach(book => {
    console.log(book);
  })
}


addBookToLibrary("Book1", "Atl", "8", false);
loopLibrary();
addBookToLibrary("Book2", "Ragnar", "123", true);
loopLibrary();
addBookToLibrary("The Hobbit", "J.R.R Tolkien", 295, false);
loopLibrary();

// // create new book-display div 

// function addElement() {
//   const bookOriginal = document.querySelector(".book-display");
//   const bookCopy = bookOriginal.cloneNode(true);
//   const newDiv = document.createElement("div");
//   const x = newDiv.textContent = prompt("");
//   bookCopy.replaceChildren(x);

//   // newDiv.appendChild(newContent);
//   const currentDiv = document.querySelector(".book-display");
//   document.body.insertBefore(bookCopy, currentDiv);
// }

// // event listener button to add new book in the library array
// const addButton = document.querySelector(".add-book");

// addButton.addEventListener("click", () => {
//   console.log("1231")
//   addElement();
// })


