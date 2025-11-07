import java.util.Scanner;

public class LibrarySystemApp {
    private final Library library = new Library("Helmington Public Library");
    private final Scanner scanner = new Scanner(System.in);

    // Main control flow of the program
    public void run() {
        // Create sample books
        Book b1 = new PhysicalBook("The Lord of the Rings", "J.R.R. Tolkien", 240);
        Book b2 = new PhysicalBook("Pride and Prejudice", "Jane Austen", 350);
        Book b3 = new EBook("How to Win Friends and Influence People", "Dale Carnegie", "EPUB", 4.5);
        Book b4 = new EBook("Your Name", "Makoto Shinkai", "PDF", 6.32);
        Book b5 = new AudioBook("Atomic Habits", "James Clear", "Random Joe", 1.5, "MP4");
        Book b6 = new AudioBook("The Psychology of Money", "Morgan Housel", "Christ", 2, "MP4");

        // Add books to the library
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);
        library.addBook(b6);

        int userCommand;
        do {
            // print out all the available menu for the users
            System.out.printf("%nWelcome to the %s!%n", library.getLibraryName());
            System.out.println("Available options:");
            System.out.println("1. Add a new book");
            System.out.println("2. Checkout a book");
            System.out.println("3. Return a book");
            System.out.println("4. List all books");
            System.out.println("5. Find a book");
            System.out.println("6. Available book list");
            System.out.println("0. Exit");
            System.out.print("Please type the option number: ");

            // get user command option number
            userCommand = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // use switch statement to perform user command
            switch (userCommand) {
                // Librarian Function
                case 1: // Add a new book
                    System.out.print("\nEnter the title of the book: ");
                    String newTitle = scanner.nextLine(); // get new book title
                    System.out.print("Enter the author of the book: ");
                    String newAuthor = scanner.nextLine(); // get new book author name
                    System.out.print("Enter the total pages of the book: ");
                    int totalPages = scanner.nextInt();
                    scanner.nextLine();

                    // create new book object by calling Book constructor
                    // and use newly created book object as arguments for the addBook function
                    library.addBook(new PhysicalBook(newTitle, newAuthor, totalPages));
                    break;

                // user function
                case 2: // Checkout a book
                    // show available books list, for enhance user experience
                    library.showAvailableBook();

                    // give user 2 ways to check out a book (By title or ID)
                    System.out.println("\nHow do you want to checkout the book?");
                    System.out.println("1. By title");
                    System.out.println("2. By book ID");
                    System.out.print("Please type the option number: ");
                    int checkoutChoice = scanner.nextInt();
                    scanner.nextLine();

                    // switch statement to perform depending on user choice of methods for check out
                    switch (checkoutChoice) {
                        // check out by title
                        case 1:
                            System.out.print("\nType the book title you want to checkout: ");
                            String titleCheckout = scanner.nextLine();
                            library.checkoutBook(titleCheckout); // call checkoutBook section
                            break;
                        case 2:
                            System.out.print("\nType the book ID you want to checkout: ");
                            int idCheckout = scanner.nextInt();
                            scanner.nextLine();
                            library.checkoutBook(idCheckout);
                            break;
                        default:
                            System.out.println("Unavailable Option. System Restart!!!\n");
                            break;
                    }
                    break;


                // same implementation as check out book
                case 3: // Return a book
                    System.out.println("\nHow do you want to return the book?");
                    System.out.println("1. By title");
                    System.out.println("2. By book ID");
                    System.out.print("Please type the option number: ");
                    int returnChoice = scanner.nextInt();
                    scanner.nextLine();

                    // implement fork to go through depending on user choice
                    switch (returnChoice) {
                        case 1:
                            System.out.print("\nType the book title you want to return: ");
                            String titleReturn = scanner.nextLine();
                            library.returnBook(titleReturn);
                            break;
                        case 2:
                            System.out.print("\nType the book ID you want to return: ");
                            int idReturn = scanner.nextInt();
                            scanner.nextLine();
                            library.returnBook(idReturn);
                            break;
                        default:
                            System.out.println("Unavailable Option. System Restart!!!\n");
                            break;
                    }
                    break;

                case 4: // List all books
                    System.out.println(library.listBooks());
                    break;

                case 5: // Find a book
                    System.out.print("Available search options:\n1. Title\n2. Book ID\n3. Author\nPlease type the option number: ");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchOption) {
                        case 1:
                            System.out.print("Enter the book title: ");
                            String searchTitle = scanner.nextLine();
                            Book foundByTitle = library.findBook(searchTitle);
                            if (foundByTitle != null) {
                                System.out.println(foundByTitle);
                            }
                            break;
                        case 2:
                            System.out.print("Enter the book ID: ");
                            int searchId = scanner.nextInt();
                            scanner.nextLine();
                            Book foundById = library.findBook(searchId);
                            if (foundById != null) {
                                System.out.println(foundById);
                            }
                            break;
                        case 3:
                            System.out.print("Enter the author's name: ");
                            String searchAuthor = scanner.nextLine();
                            System.out.println(library.findBooksByAuthor(searchAuthor));
                            break;
                        default:
                            System.out.println("Option Unavailable!!!");
                            break;
                    }
                    break;

                case 6: // show available book list that can check out
                    library.showAvailableBook();
                    break;

                case 0: // Shut down
                    System.out.println("\nSystem shutting down...");
                    break;

                // to handle the invalid input from user
                // update: need to handle wrong type exception
                // current code only handle typing invalid integer
                default:
                    System.out.println("\nInvalid input!!!\n");
                    break;
            }
        } while (userCommand != 0); // 0 to break out of do while loop a.k.a ending the program

        scanner.close();
    }
}
