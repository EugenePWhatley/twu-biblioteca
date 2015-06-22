package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eugenew on 6/22/15.
 */
public class ReturnBookCommand implements BibliotecaCommand{
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private BufferedReader reader;

    public ReturnBookCommand(Biblioteca biblioteca, PrintStream printStream, BufferedReader reader) {
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public void execute() {
        printStream.println("Enter Book to return:");
        String bookTitle = readLine();
        boolean bool = biblioteca.returnBook(bookTitle);
        if(bool){
            printStream.println("You have successfully returned this book");
        }else{
            printStream.println("Sorry, could not return that book.");
        }
    }

    private String readLine() {
        String bookTitle = "";
        try {
            bookTitle = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookTitle;
    }
}
