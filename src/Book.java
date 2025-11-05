public class Book {
    public static int totalBooks = 0;
    private String title;
    private String author;
    private boolean isCheckedOut;
    private int bookID;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
        this.bookID = totalBooks; // Assign current totalBooks as ID
        totalBooks++; // Increment totalBooks for the next book
    }

    // will migrate this entire checkout and return function to the library class soon
    // I believe book class only handle its own field and getter method
    // Let library class handle all the main functionality of the system
    public void checkout() {
        if (!isCheckedOut) {
            isCheckedOut = true;
            System.out.printf("%nThe Book '%s' has been checked out.%n", this.title);
        } else {
            System.out.printf("%nThe Book '%s' is not available to checkout (already checked out).%n", this.title);
        }
    }

    public void returnBook() {
        if (isCheckedOut) {
            isCheckedOut = false;
            System.out.printf("%nThe Book '%s' has been returned.%n", this.title);
        } else {
            System.out.printf("%nThe Book '%s' was not checked out.%n", this.title);
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public Boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    public String getStatus() {
        return isCheckedOut ? "Not Available" : "Available";
    }

    public int getBookID() {
        return this.bookID;
    }

    @Override
    public String toString() {
        return "\nBook ID: " + this.bookID +
                "\nTitle: " + this.title +
                "\nAuthor: " + this.author +
                "\nStatus: " + this.getStatus() + "\n";
    }
}
