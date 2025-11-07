public class EBook extends Book{
    private final String fileFormat;
    private final double fileSizeMB;

    // creating constructor by inheriting super constructor
    public EBook(
            String title,
            String author,
            String fileFormat,
            double fileSizeMB
    ) {
        super(title, author);
        this.fileFormat = fileFormat;
        this.fileSizeMB = fileSizeMB;
    }

    // Abstract Methods
    // implementing the abstract method to apply EBook behaviors
    @Override
    public void access() {
        // display the Downloading message to let user know that they are accessing the ebook now
        // use $.2f to truncate the fileSizeMB(double variable) into 2 decimal place
        System.out.printf("%nDownloading %s.%s.....%nTotal file size: %.2f mb%n", this.getTitle(), this.fileFormat, this.fileSizeMB);
    }

    @Override
    public void returnBook() {
        // handle the returnBook() is not necessary in EBook
        // returnBook is only for the PhysicalBook to achieve Polymorphism
        System.out.printf("No need to return the Ebook %s.%s", this.getTitle(), this.fileFormat);
    }

    // getter method for the specific private field of EBook
    public String getFileFormat() {
        return this.fileFormat;
    }

    public double getFileSizeMB() {
        return this.fileSizeMB;
    }

    // Overriding to String to display object information instead of object hash code
    @Override
    public String toString() {
        return String.format(
                "%nEBook" +
                "%nBook ID: %s" +
                "%nTitle: %s.%s" +
                " (%.2fmb)" +
                "%nAuthor: %s%n",
                this.getBookID(),
                this.getTitle(),
                this.getFileFormat(),
                this.fileSizeMB,
                this.getAuthor()
        );
    }
}
