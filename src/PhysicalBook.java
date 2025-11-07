public class PhysicalBook extends Book{

    private final int totalPages;

    // inherit the super constructor from parent Book Class
    public PhysicalBook(String title, String author, int totalPages) {
        super(title, author);
        this.totalPages = totalPages;
    }

    // Override the abstract method
    // reimplement checkout as access method
    @Override
    public void access() {
        // if book is available perform checkout
        if (isAvailable) {
            System.out.printf("%nThe Book '%s' has been borrowed.%n", this.getTitle());
            isAvailable = false; // update the book availability to false
        } else {
            System.out.printf("%nThe Book '%s' is not available to borrow.%n", this.getTitle());
        }
    }

    // specific method for the Physical Book
    public String getStatus() {
        return isAvailable ? "Available" : "not Available";
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    // return book function to allow user to return the physical book that they have borrowed
    // will reimplement in the User class in the future because its user related function
    @Override
    public void returnBook() {
        // if only book is not available
        if (!isAvailable) {
            System.out.printf("%nThe Book '%s' has been returned.%n", this.getTitle());
            isAvailable = true; // switch the book availability back to true
        } else {
            System.out.printf("%nThe Book '%s' is not yet borrowed by anyone.%n", this.getTitle());
        }
    }


    // override toString to display book object information instead of Object Hashcode
    @Override
    public String toString() {
        return String.format(
                "%nPhysical Book" +
                "%nBook ID: %s" +
                "%nTitle: %s" +
                "%nAuthor: %s" +
                "%nStatus: %s\n",
                this.getBookID(),
                this.getTitle(),
                this.getAuthor(),
                this.getStatus()
        );
    }


}
