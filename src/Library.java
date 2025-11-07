import java.util.ArrayList;

public class Library {
    private final String libraryName;
    private final ArrayList<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // add Book Object into the ArrayList of books
    public void addBook(Book book) {
        books.add(book);
        System.out.printf("%nThe book '%s' is added to the %s.%n", book.getTitle(), libraryName);
    }

    // remove Book Obejct from ArrayList of books
    public void removeBook(Book book) {
        if (books.remove(book)) {
            System.out.printf("%nThe book '%s' is removed from the %s.%n", book.getTitle(), libraryName);
        } else {
            System.out.printf("%nThe book '%s' was not found in the %s.%n", book.getTitle(), libraryName);
        }
    }

    // getter method for the library Name
    public String getLibraryName() {
        return this.libraryName;
    }

    // getter method current books ArrayList size ( which is the same as current total books in the library )
    public int getSize() {
        return books.size();
    }

    // Override toString to display all the books available in the library
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Book book : books) {
            builder.append(book);
        }
        return builder.toString();
    }

    // function to display all the status of the books
    public String listBooks() {
        // stringBuilder object to build string from each book status
        StringBuilder builder = new StringBuilder(this.libraryName + " Library Book List: \n");

        // if books arrayList is empty, append no books was found in stringBuilder
        if (books.isEmpty()) {
            builder.append("No books in the library.");
        } else {
            // if arrayList has book object, append each of the book.toString() or book object to the stringBuilder
            for (Book book : books) {
                builder.append(book);
            }
        }
        // return the stringBuilder that includes all the books in the library
        return builder.toString();
    }

    // function to find the book via title
    public Book findBook(String title) {
        // traverse through book ArrayList
        for (Book book : books) {
            // compare title(String of each book title to the user target title
            if (title.equalsIgnoreCase(book.getTitle())) {
                // if we found matching title return that book
                return book;
            }
        }
        // if target book title was not found in the list
        System.out.println("\nNo book found with Title: " + title);
        return null; // return the null object
    }

    // overloading method for the book id argument
    public Book findBook(int id) {
        for (Book book : books) {
            if (id == book.getBookID()) {
                return book;
            }
        }
        System.out.println("\nNo book found with ID: " + id);
        return null;
    }

    // method to find books via Author Name
    // use separate method instead of overloading the findBooks method
    // This function will return multiple books that we found match with the author name
    public String findBooksByAuthor(String authorName) {
        StringBuilder booksbyAuthor = new StringBuilder();
        // boolean to track if the authors books exist or not
        boolean found = false;
        // traverse through list
        for (Book book : books) {
            // compare authorName(target string) with all the book.author from book list
            if (authorName.equalsIgnoreCase(book.getAuthor())) {
                // if matching was found append the book
                booksbyAuthor.append(book);
                found = true;
            }
        }
        if (!found) {
            return authorName + "'s books were not found.";
        }
        return booksbyAuthor.toString();
    }

    // function that perform check out book for users
    public void checkoutBook(String title) {
        // use findBook methods to find target book
        Book targetBook = findBook(title);
        // if book with desired title or id was found
        if (targetBook != null) {
            // perform checkout
            targetBook.access();
            /* should not call checkout from Book class which enhance complexity
             I will fix it to just update the isCheckedOut boolean of Book class.
            */
        } else {
            // not found message
            System.out.printf("%nBook '%s' is not found in the library.%n", title);
        }
    }

    // method overloading to allow user to check out books via id
    public void checkoutBook(int id) {
        Book targetBook = findBook(id);
        if (targetBook != null) {
            targetBook.access();
        } else {
            System.out.printf("%nBook with ID %d is not found in the library.%n", id);
        }
    }

    // same implementation as check out book ( just switch the isCheckedOut boolean from Book class back to false.
    public void returnBook(String title) {
        Book targetBook = findBook(title);
        if (targetBook != null) {
            targetBook.returnBook();
        } else {
            System.out.printf("%nBook '%s' is not found in the library.%n", title);
        }
    }

    // method overload for return book via id
    public void returnBook(int id) {
        Book targetBook = findBook(id);
        if (targetBook != null) {
            targetBook.returnBook();
        } else {
            System.out.printf("%nBook with ID %d is not found in the library.%n", id);
        }
    }

    // function that display only the available books in the library (isCheckedOut == false)
    public void showAvailableBook() {
        StringBuilder builder = new StringBuilder("\n\nBooks that are available:\n");

        // boolean to check is there any books available in the library
        boolean anyAvailable = false;

        // traverse through book ArrayList
        for (Book book : books) {
            // if current index book (isCheckedOut == false)
            // put the book.toString() a.k.a book information in StringBuilder
            if (book.isAvailable()) {
                // formatting the builder to enhance the readability of string
                builder.append("ID: ").append(book.getBookID()).append("\t\t")
                        .append("| ( ").append(book.getClass().getSimpleName()).append(" )")
                        .append(" Book Name: ").append(book.getTitle())
                        .append(" (Written by: ").append(book.getAuthor()).append(")\n\n");
                // if at least one book was found, it will turn true ( indicating library have available books )
                anyAvailable = true;
            }
        }
        // if anyAvailable == false ( which means library is empty for now )
        if (!anyAvailable) {
            builder.append("No books currently available.");
        }
        System.out.println(builder);
    }

    // function that search books by its index in the ArrayList
    public Book getBookbyIndex(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }
}
