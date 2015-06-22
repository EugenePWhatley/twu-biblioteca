package com.twu.biblioteca;

/**
 * Created by eugenew on 6/22/15.
 */
public class ListMoviesCommand implements BibliotecaCommand {
    private Biblioteca biblioteca;

    public ListMoviesCommand(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    @Override
    public void execute() {
        biblioteca.listMovies();
    }
}
