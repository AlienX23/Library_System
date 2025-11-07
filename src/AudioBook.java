public class AudioBook extends Book{
    private final String narrator;
    private final double durationHours; // length in hours
    private final String audioFormat;

    // build constructor by inherit the super constructor
    public AudioBook(
            String title,
            String author,
            String narrator,
            double durationHours,
            String audioFormat
    ) {
        super(title, author);
        this.narrator = narrator;
        this.durationHours = durationHours;
        this.audioFormat = audioFormat;
    }

    @Override
    public void access() {
        // display the downloading message to let the user know that they are accessing the audio Book
        System.out.printf("%nDownloading %s.%s..... (Narrated by %s)%nTotal Duration: %.2f%n", this.getTitle(), this.audioFormat, this.narrator, this.durationHours);;
    }

    @Override
    public void returnBook() {
        // handle the returnBook() is not necessary in AudioBook
        // returnBook is only for the PhysicalBook to achieve Polymorphism
        System.out.printf("No need to return the Audio book %s.%s(Narrated by %s)%n%n", this.getTitle(), this.audioFormat, this.narrator);
    }

    // getter method for the private specific field of AudioBook
    public String getNarrator() {
        return this.narrator;
    }

    public double getDurationHours() {
        return this.durationHours;
    }

    public String getAudioFormat() {
        return this.audioFormat;
    }

    // Overriding toString() to display object information instead of Object Hash Code
    public String toString() {
        return String.format(
                "%nAudio Book" +
                "%nBook ID: %s" +
                "%nTitle: %s.%s" +
                "%nAuthor: %s" +
                "%nTotal duration: %.2f Hour" +
                "%nNarrated by: %s%n",
                this.getBookID(),
                this.getTitle(),
                this.audioFormat,
                this.getAuthor(),
                this.durationHours,
                this.narrator
        );
    }
}
