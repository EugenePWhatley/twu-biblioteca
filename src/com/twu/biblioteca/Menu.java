package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by angoh on 6/17/15.
 */
public class Menu {
    private Biblioteca biblioteca;
    private BufferedReader reader;
    private PrintStream printStream;
    private boolean stillAlive;
    private final Map<String, BibliotecaCommand> commandMap;

    public Menu(PrintStream printStream, Biblioteca biblioteca, BufferedReader reader, Map<String, BibliotecaCommand> commandMap){
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = reader;
        this.stillAlive = true;
        this.commandMap = commandMap;
    }

    public boolean isStillAlive() {
        return stillAlive;
    }

    public void displayMenu() {
        printStream.println("MAIN MENU");
        printStream.println("- List Books");
        printStream.println("- List Movies");
        printStream.println("- Checkout Book");
        printStream.println("- Checkout Movie");
        printStream.println("- Return");
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
        commandMap.put("quit", new QuitCommand(this));
        try{
            commandMap.get(selection).execute();
        } catch (NullPointerException e){
            printStream.println("That's not a valid option");
        }
    }

    public void quit() {
        stillAlive = false;
    }
}
