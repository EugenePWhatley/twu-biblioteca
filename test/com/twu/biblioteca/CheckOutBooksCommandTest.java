package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/19/15.
 */
public class CheckOutBooksCommandTest {
    @Test
    public void shouldCheckOutBooksWhenCommandSelectedFromMenu(){
        Biblioteca biblioteca = mock(Biblioteca.class);
        CheckOutBooksCommand checkOutBooksCommand = new CheckOutBooksCommand(biblioteca);

        checkOutBooksCommand.execute();
//         verify(biblioteca).
    }
}
