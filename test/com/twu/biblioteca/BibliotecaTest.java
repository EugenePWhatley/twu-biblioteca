package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by egalperi on 6/16/15.
 */
public class BibliotecaTest {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;
    private List<Movie> movies;
    private Book book1, book2, book3;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        reader = mock(BufferedReader.class);
        biblioteca = new Biblioteca(printStream, books, movies);
        book1 = mock(Book.class);
        when(book1.title()).thenReturn("Book 1");
        book2 = mock(Book.class);
        when(book2.title()).thenReturn("Book 2");
        book3 = mock(Book.class);
        when(book3.title()).thenReturn("Book 3");

    }


    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        biblioteca.listBooks();

        verify(printStream).println("");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoMovies() {
        biblioteca.listMovies();
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
        Book book4 = new Book("Akon's thesis", "Akon", "4000");
        Book book5 = new Book("Conversations on String Theory", "Raymond", "1991");
        books.add(book4);
        books.add(book5);
        biblioteca.checkoutBooks(book4);
        biblioteca.listBooks();

        verify(printStream, never()).format(anyString(), eq("Akon's thesis"), eq("Akon"), eq("4000"));
    }

    @Test
    public void shouldReturnFalseIfBookIsAlreadyCheckedOut() {
        Book book4 = new Book("Akon's thesis", "Akon", "4000");
        books.add(book4);
        book4.checkOut();
        assertFalse(biblioteca.checkoutBooks(book4));
    }

    @Test
    public void shouldReturnFalseIfMovieIsAlreadyCheckedOut() {
        Movie movie = new Movie("Akon's thesis", "Akon", "4000", "10");
        movies.add(movie);
        movie.checkOut();
        assertFalse(biblioteca.checkoutMovie(movie));
    }

    @Test
    public void shouldReturnTrueIfBookIsNotAlreadyCheckedOut() {
        Book book4 = new Book("Akon's thesis", "Akon", "4000");
        books.add(book4);
        assertTrue(biblioteca.checkoutBooks(book4));
    }

    @Test
    public void shouldReturnTrueIfMovieIsNotAlreadyCheckedOut() {
        Movie movie = new Movie("Akon's thesis", "Akon", "4000", "10");
        movies.add(movie);
        assertTrue(biblioteca.checkoutMovie(movie));
    }

    @Test
    public void shouldBeAbleToReturnBooks(){
        when(book1.checkIn()).thenReturn(true);
        when(book2.checkIn()).thenReturn(false);
        assertEquals(biblioteca.returnBook(book1), true);
        assertFalse(biblioteca.returnBook(book2));
    }

}



