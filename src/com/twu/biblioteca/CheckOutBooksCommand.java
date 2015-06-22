package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by eugenew on 6/19/15.
 */
public class CheckOutBooksCommand implements BibliotecaCommand {
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private String bookTitle;

    public CheckOutBooksCommand(Biblioteca biblioteca, PrintStream printStream,String bookTitle) {

        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.bookTitle = bookTitle;
    }

    @Override
    public void execute() {
        boolean checkout = biblioteca.checkoutBooks(bookTitle);
        if(checkout) {
            printStream.println("Success! Enjoy your book.");
        }else{
            printStream.println("Could not check out book with that title.");
        }
    }
}
