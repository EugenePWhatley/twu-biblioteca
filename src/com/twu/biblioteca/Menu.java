package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;

/**
 * Created by angoh on 6/17/15.
 */
public class Menu {
    private Biblioteca biblioteca;
    private BufferedReader reader;
    private PrintStream printStream;
    private boolean stillAlive;

    public Menu(PrintStream printStream, Biblioteca biblioteca, BufferedReader reader){
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = reader;
        this.stillAlive = true;
    }

    public boolean isStillAlive() {
        return stillAlive;
    }

    public void displayMenu() {
        printStream.println("MAIN MENU");
        printStream.println("- List Books");
        printStream.println("- List Movies");
        printStream.println("- Checkout Book [book title]");
        printStream.println("- Checkout Movie [movie title]");
        printStream.println("- Return [book title]");
        printStream.println("- Quit");
        printStream.println("Enter your selection");
    }

    public String getUserInput() {
        String userSelection = " ";
        try {
            userSelection = reader.readLine();
        }
        catch (IOException e) {
            printStream.println(e.getMessage());
        }
        return userSelection;
    }

    public void selectOption(String selection) {
        selection = selection.toLowerCase();
        Map<String, BibliotecaCommand> commandMap = new HashMap<String, BibliotecaCommand>();
        commandMap.put("list books", new ListBooksCommand(biblioteca));
//        commandMap.put(contains("checkout book"), new CheckOutBooksCommand(biblioteca, printStream, selection.replace("checkout book", "").trim()));
        commandMap.put("list movies", new ListMoviesCommand(biblioteca));
//        commandMap.put("checkout movies", new CheckOutMovieCommand(biblioteca));
        commandMap.put("quit", new QuitCommand(this));

        if (selection.contains("list books")) {
            commandMap.get(selection).execute();
        }
        else if (selection.contains("checkout book")){
            commandMap.get(selection).execute();
        }
        else if (selection.contains("list movies")){
            commandMap.get(selection).execute();
        }
        else if (selection.contains("checkout movie")){
            boolean checkout = biblioteca.checkoutMovie(selection.replace("checkout movie", "").trim());
            if(checkout) {
                printStream.println("Success! Enjoy your movie.");
            }else{
                printStream.println("Could not check out movie with that title.");
            }
        }
        else if (selection.contains("return")) {
            boolean bool = biblioteca.returnBook(selection.replace("return","").trim());
            if(bool){
                printStream.println("You have successfully returned this book");
            }else{
                printStream.println("Sorry, could not return that book.");
            }
        }
        else if (selection.contains("quit")) {
            commandMap.get(selection).execute();
        }
        else{
            printStream.println("That's not a valid option");
        }
    }

    public void quit() {
        stillAlive = false;
    }
}
