package com.twu.biblioteca;

/**
 * Created by eugenew on 6/22/15.
 */
public class QuitCommand implements BibliotecaCommand {
    private Menu menu;

    public QuitCommand(Menu menu) {

        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.quit();
    }
}
