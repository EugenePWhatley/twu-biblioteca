package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by angoh on 6/17/15.
 */
public class MenuTest {

    private BufferedReader reader;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;
    private Map<String, BibliotecaCommand> commandMap;
    private ListBooksCommand listBooksCommand;

    @Before
    public void setUp() throws IOException{
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        biblioteca = mock(Biblioteca.class);
        listBooksCommand = mock(ListBooksCommand.class);
        commandMap = new HashMap<String, BibliotecaCommand>();
        menu = new Menu(printStream, biblioteca, reader, commandMap, listBooksCommand);
        when(reader.readLine()).thenReturn("list items");
    }

    @Test
    public void shouldAskForInputWhenMenuIsShown() {
        menu.displayMenu();
        verify(printStream).println("Enter your selection");
    }

    @Test
    public void shouldHandleInvalidUserInput() {
        menu.selectOption("boo");
        verify(printStream).println("That's not a valid option");
    }

    @Test
    public void shouldHandleValidUserInput() {
        String selection = "list books";

        menu.selectOption(selection);

        verify(listBooksCommand).execute();
    }
}
