package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/16/15.
 */
public class BibliotecaTest {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;
    private Book book1, book2, book3;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        reader = mock(BufferedReader.class);
        biblioteca = new Biblioteca(printStream, books);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
    }


    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        biblioteca.listBooks();

        verify(printStream).println("");
    }

    @Test
    public void shouldPrintOneBookWhenThereIsOneBook() {
        books.add(book1);
        biblioteca.listBooks();

        verify(printStream).println(anyString());
    }

    @Test
    public void shouldPrintAllBooksWhenThereAreMoreThanOneBook() {
        books.add(book1);
        books.add(book2);
        books.add(book3);
        biblioteca.listBooks();

        verify(printStream).println(anyString());
        verify(printStream).println(anyString());
        verify(printStream).println(anyString());
    }

    @Test
    public void shouldNotIncludeCheckedOutBooksInList() {
        books.add(book1);
        biblioteca.checkout(book1);
        biblioteca.listBooks();

        verify(printStream, never()).format(contains(book1.title()));
    }

}



