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
    public void moveManagerPositive() {
        MovieManager manager = new MovieManager();
        fillMoveManager15(manager);
        testMoveManager(manager, 15, 10);

        manager = new MovieManager(15);
        fillMoveManager15(manager);
        testMoveManager(manager, 15, 15);

        manager = new MovieManager(12);
        fillMoveManager10(manager);
        testMoveManager(manager, 10, 10);
    }

    private void testMoveManager(MovieManager manager, int testMoviesLength, int expectedMoviesLength) {
        Movie[] expectedMovies = getExpectedArray(expectedMoviesLength, 15 - testMoviesLength);

        Movie[] actualMovies = manager.getLastMovies();
        assertArrayEquals(expectedMovies, actualMovies);
    }

    private void fillMoveManager15(MovieManager manager) {
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
    }

    private void fillMoveManager10(MovieManager manager) {
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
    }

    private Movie[] getExpectedArray(int length, int offset) {
        Movie[] expectedTmp = new Movie[15];
        expectedTmp[0] = movie15;
        expectedTmp[1] = movie14;
        expectedTmp[2] = movie13;
        expectedTmp[3] = movie12;
        expectedTmp[4] = movie11;
        expectedTmp[5] = movie10;
        expectedTmp[6] = movie9;
        expectedTmp[7] = movie8;
        expectedTmp[8] = movie7;
        expectedTmp[9] = movie6;
        expectedTmp[10] = movie5;
        expectedTmp[11] = movie4;
        expectedTmp[12] = movie3;
        expectedTmp[13] = movie2;
        expectedTmp[14] = movie1;

        Movie[] output = new Movie[length];
        System.arraycopy(expectedTmp, offset, output, 0, length);
        return output;
    }

}
