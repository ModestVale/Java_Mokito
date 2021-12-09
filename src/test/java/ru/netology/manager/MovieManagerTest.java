package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    @Test
    public void moveManagerPositive() {
        MovieManager manager = new MovieManager();
        testMoveManager(manager,15,10);

        manager = new MovieManager(15);
        testMoveManager(manager,15,15);

        manager = new MovieManager(12);
        testMoveManager(manager,10,10);
    }

    private void testMoveManager(MovieManager manager, int testMoviesLength, int expectedMoviesLength)
    {
        Movie[] testMovies = new Movie[testMoviesLength];

        for (int i = 0; i < testMoviesLength; i++) {
            Movie movie = new Movie();
            movie.setTitle("Фильм" + i);
            testMovies[i] = movie;
            manager.addMovie(movie);
        }

        Movie[] expectedMovies = new Movie[expectedMoviesLength];

        for(int i =0, j = (testMoviesLength-1); i < expectedMoviesLength; i++, j-- )
        {
            expectedMovies[i] = testMovies[j];
        }

        Movie[] actualMovies = manager.getLastMovies();
        assertArrayEquals(expectedMovies,actualMovies);
    }

}
