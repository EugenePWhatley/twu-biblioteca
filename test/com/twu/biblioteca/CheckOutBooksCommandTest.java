package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/19/15.
 */
public class CheckOutBooksCommandTest {
    private PrintStream printStream;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldCheckOutBooksWhenCommandSelectedFromMenu(){
        Biblioteca biblioteca = mock(Biblioteca.class);
        String bookTitle = "Harry Potter";
        CheckOutBooksCommand checkOutBooksCommand = new CheckOutBooksCommand(biblioteca, printStream, bookTitle);

        checkOutBooksCommand.execute();
         verify(biblioteca).checkoutBooks(bookTitle);
    }
}
