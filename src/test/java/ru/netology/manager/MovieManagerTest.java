package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    private Movie movie1 = new Movie("Фильм1");
    private Movie movie2 = new Movie("Фильм2");
    private Movie movie3 = new Movie("Фильм3");
    private Movie movie4 = new Movie("Фильм4");
    private Movie movie5 = new Movie("Фильм5");
    private Movie movie6 = new Movie("Фильм6");
    private Movie movie7 = new Movie("Фильм7");
    private Movie movie8 = new Movie("Фильм8");
    private Movie movie9 = new Movie("Фильм9");
    private Movie movie10 = new Movie("Фильм10");
    private Movie movie11 = new Movie("Фильм11");
    private Movie movie12 = new Movie("Фильм12");
    private Movie movie13 = new Movie("Фильм13");
    private Movie movie14 = new Movie("Фильм14");
    private Movie movie15 = new Movie("Фильм15");

    @Test
    public void shouldMoveManagerGetTenLastMoviesWhenFifteenAdded() {
        MovieManager manager = new MovieManager();
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        manager.addMovie(movie12);
        manager.addMovie(movie13);
        manager.addMovie(movie14);
        manager.addMovie(movie15);

        Movie[] expectedMovies = new Movie[10];
        expectedMovies[0] = movie15;
        expectedMovies[1] = movie14;
        expectedMovies[2] = movie13;
        expectedMovies[3] = movie12;
        expectedMovies[4] = movie11;
        expectedMovies[5] = movie10;
        expectedMovies[6] = movie9;
        expectedMovies[7] = movie8;
        expectedMovies[8] = movie7;
        expectedMovies[9] = movie6;

        Movie[] actualMovies = manager.getLastMovies();
        assertArrayEquals(expectedMovies, actualMovies);
    }

    @Test
    public void shouldMoveManagerGetFifteenLastMoviesWhenFifteenAdded() {
        MovieManager manager = new MovieManager(15);
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);
        manager.addMovie(movie11);
        manager.addMovie(movie12);
        manager.addMovie(movie13);
        manager.addMovie(movie14);
        manager.addMovie(movie15);

        Movie[] expectedMovies = new Movie[15];

        expectedMovies[0] = movie15;
        expectedMovies[1] = movie14;
        expectedMovies[2] = movie13;
        expectedMovies[3] = movie12;
        expectedMovies[4] = movie11;
        expectedMovies[5] = movie10;
        expectedMovies[6] = movie9;
        expectedMovies[7] = movie8;
        expectedMovies[8] = movie7;
        expectedMovies[9] = movie6;
        expectedMovies[10] = movie5;
        expectedMovies[11] = movie4;
        expectedMovies[12] = movie3;
        expectedMovies[13] = movie2;
        expectedMovies[14] = movie1;

        Movie[] actualMovies = manager.getLastMovies();
        assertArrayEquals(expectedMovies, actualMovies);
    }

    @Test
    public void shouldMoveManagerGetTenLastMoviesWhenTenAdded() {
        MovieManager manager = new MovieManager(10);

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
        manager.addMovie(movie8);
        manager.addMovie(movie9);
        manager.addMovie(movie10);

        Movie[] expectedMovies = new Movie[10];
        expectedMovies[0] = movie10;
        expectedMovies[1] = movie9;
        expectedMovies[2] = movie8;
        expectedMovies[3] = movie7;
        expectedMovies[4] = movie6;
        expectedMovies[5] = movie5;
        expectedMovies[6] = movie4;
        expectedMovies[7] = movie3;
        expectedMovies[8] = movie2;
        expectedMovies[9] = movie1;

        Movie[] actualMovies = manager.getLastMovies();
        assertArrayEquals(expectedMovies, actualMovies);
    }
}
