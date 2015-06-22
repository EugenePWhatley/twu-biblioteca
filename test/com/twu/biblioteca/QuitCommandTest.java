package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eugenew on 6/22/15.
 */
public class QuitCommandTest {

    @Test
    public void shouldExitMenuWhenQuitIsCalled(){
        Menu menu = mock(Menu.class);
        QuitCommand quitCommand = new QuitCommand(menu);

        quitCommand.execute();

        verify(menu).quit();
    }

}