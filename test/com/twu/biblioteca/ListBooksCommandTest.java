package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/19/15.
 */
public class ListBooksCommandTest {



    @Test
    public void shouldListBooksWhenCommandSelectedFromMenu(){
        Biblioteca biblioteca = mock(Biblioteca.class);
        ListBooksCommand listBooksCommand = new ListBooksCommand(biblioteca);

        listBooksCommand.execute();
        verify(biblioteca).listBooks();
    }
}
