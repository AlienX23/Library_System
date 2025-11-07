public abstract class Book {
    public static int totalBooks = 0;

    private final String title;
    private final String author;
    private final int bookID;
    protected boolean isAvailable = true; // set book availability as true to all new book objects

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookID = totalBooks; // Assign current totalBooks as ID
        totalBooks++; // Increment totalBooks for the next book
    }

    // Abstract method to access different book types
    public abstract void access();

    // Abstract method to allow user to return Physical Book
    public abstract void returnBook();

    // Getter method for title
    public String getTitle() {
        return this.title;
    }

    // Getter method for author
    public String getAuthor() {
        return this.author;
    }

    // Getter method for bookID
    public int getBookID() {
        return this.bookID;
    }

    // Method to check availability
    public boolean isAvailable() {
        return isAvailable;
    }
}
