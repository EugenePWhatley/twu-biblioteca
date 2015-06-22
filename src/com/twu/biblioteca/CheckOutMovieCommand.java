package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by eugenew on 6/22/15.
 */
public class CheckOutMovieCommand implements BibliotecaCommand {
    private Biblioteca biblioteca;
    private PrintStream printStream;
    private BufferedReader reader;

    public CheckOutMovieCommand(Biblioteca biblioteca, PrintStream printStream, BufferedReader reader) {

        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public void execute() {
        printStream.println("Enter movie selection: ");
        String movieTitle = readLine();
        boolean checkout = biblioteca.checkoutMovie(movieTitle);
        if(checkout) {
            printStream.println("Success! Enjoy your movie.");
        }else{
            printStream.println("Could not check out movie with that title.");
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
