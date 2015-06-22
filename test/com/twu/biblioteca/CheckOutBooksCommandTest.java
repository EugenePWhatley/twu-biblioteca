package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eugenew on 6/19/15.
 */
public class CheckOutBooksCommandTest {
    private PrintStream printStream;
    private BufferedReader reader;
    private Biblioteca biblioteca;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
    }

    @Test
    public void shouldCheckOutBooksWhenCommandSelectedFromMenu() throws IOException {
        String bookTitle = "Harry Potter";
        when(reader.readLine()).thenReturn(bookTitle);
        CheckOutBooksCommand checkOutBooksCommand = new CheckOutBooksCommand(biblioteca, printStream, reader);

        checkOutBooksCommand.execute();
         verify(biblioteca).checkoutBooks(bookTitle);
    }
}
