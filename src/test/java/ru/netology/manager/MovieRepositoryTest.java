package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {
    @Test
    public void MovieRepository_test() {
        MovieRepository repository = new MovieRepository();
        int testMoviesLength = 15;

        Movie[] testMovies = new Movie[testMoviesLength];

        for (int i = 0; i < testMoviesLength; i++) {
            Movie movie = new Movie();
            movie.setId(i);
            movie.setTitle("Фильм" + i);
            testMovies[i] = movie;
            repository.save(movie);
        }

        Movie[] actualMovies = repository.findAll();
        assertArrayEquals(testMovies, actualMovies);

        assertEquals("Фильм4", repository.findById(4).getTitle());
        repository.removeById(4);
        assertNull(repository.findById(4));

        try {
            repository.removeById(4);
            assertTrue(false);
        } catch (RuntimeException ex) {
            assertEquals("move not found", ex.getMessage());
        }

        repository.removeAll();

        assertEquals(0, repository.findAll().length);

    }

}
