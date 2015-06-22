package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/22/15.
 */
public class ListMoviesCommandTest {

    @Test
    public void shouldListMoviesWhenCommandSelectedFromMenu(){
        Biblioteca biblioteca = mock(Biblioteca.class);
        ListMoviesCommand listMoviesCommand = new ListMoviesCommand(biblioteca);

        listMoviesCommand.execute();
        verify(biblioteca).listMovies();
    }
}