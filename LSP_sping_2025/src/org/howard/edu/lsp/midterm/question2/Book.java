package org.howard.edu.lsp.midterm.question2;

/**
 * Beginning of question 2 midterm.
 * Initiating a class book in a library with a title, author, ISBN, and year published.
 * This class provides methods to get and set book details while also ensuring encapsulation as required by the question.
 * References:
 *  - Lecture Notes on Object-Oriented Programming, javadocs
 *  - Encapsulation, getter, setter methods
 *  - assignment 2 submission file
 *  - javadoc documentation
 */
public class Book {
    // Private attributes to ensure encapsulation
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    /**
     * Constructs a new Book object with the given title, author, ISBN, and publication year.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param ISBN The ISBN number of the book, which is a unique identifier.
     * @param yearPublished The year the book was published.
     */
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    /**
     * Gets the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     * @param title The new title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author of the book.
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     * @param author The new author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     * @return The ISBN of the book.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Sets the ISBN of the book.
     * @param ISBN The new ISBN of the book.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Gets the year the book was published.
     * @return The year the book was published.
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     * @param yearPublished The new publication year of the book.
     */
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Compares two Book objects based on ISBN and author.
     * @param obj The object to compare with.
     * @return true if the books have the same ISBN and author, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
    }

    /**
     * Returns a string representation of the Book object.
     * @return A formatted string containing the book details.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}

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
