package org.howard.edu.lsp.midterm.question2;


/**
 * The BookDriver class demonstrates the functionality of the Book class.
 * It creates book instances, checks equality, and prints book details.
 */
class BookDriver {
    /**
     * The main method to execute the Book class functionality.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Demonstrating the equals method
        System.out.println(book1.equals(book2));
        System.out.println(book1.equals(book3));
        // Printing book details
        System.out.println(book1);
    }
}