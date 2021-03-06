package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eugenew on 6/19/15.
 */
public class CheckOutBooksCommand implements BibliotecaCommand {
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private BufferedReader reader;

    public CheckOutBooksCommand(Biblioteca biblioteca, PrintStream printStream, BufferedReader reader) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public void execute() {
        printStream.println("Enter book selection: ");
        String bookTitle = readLine();
        boolean checkout = biblioteca.checkoutBooks(bookTitle);
        if(checkout) {
            printStream.println("Success! Enjoy your book.");
        }else{
            printStream.println("Could not check out book with that title.");
        }
    }

    private String readLine() {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
