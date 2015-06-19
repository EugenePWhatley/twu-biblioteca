package com.twu.biblioteca;

import java.io.*;
import java.util.List;

/**
 * Created by egalperi on 6/16/15.
 */
public class Biblioteca {

    private PrintStream printStream;
    private List<Book> books;
    private List<Movie> movies;

    public Biblioteca(PrintStream printStream, List<Book> books, List<Movie> movies) {
        this.printStream = printStream;
        this.books = books;
        this.movies = movies;
    }

    public void listBooks() {
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                book.printDetails(printStream);
            }
        }
        printStream.println("");
    }


    public boolean checkoutBooks(Book book) {
        if(book.isCheckedOut()){
            return false;
        }
        book.checkOut();
        return true;
    }

    public boolean checkoutBooks(String bookTitle){
        for(Book book: books){
            if(book.title().equalsIgnoreCase(bookTitle)){
                return checkoutBooks(book);
            }
        }
        return false;
    }

    public boolean returnBook(Book book) {
        return book.checkIn();
    }

    public boolean returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.title().equalsIgnoreCase(bookTitle)) {
                return returnBook(book);
            }
        }
        return false;
    }

    public void listMovies() {
        for (Movie movie : movies) {
            if (!movie.isCheckedOut()) {
                movie.printDetails(printStream);
            }
        }
        printStream.println("");
    }

    public boolean checkoutMovie(String movieTitle) {
        for(Movie movie: movies){
            if(movie.title().equalsIgnoreCase(movieTitle)){
                return checkoutMovie(movie);
            }
        }
        return false;
    }

    public boolean checkoutMovie(Movie movie) {
        if(movie.isCheckedOut()){
            return false;
        }
        movie.checkOut();
        return true;
    }
}
