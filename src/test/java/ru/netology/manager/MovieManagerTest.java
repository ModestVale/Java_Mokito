package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieManagerTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager managerDefault = new MovieManager(repository);
    @InjectMocks
    private MovieManager managerCustom = new MovieManager(repository, 15);

    @Test
    public void moveManager_getLastMovies() {
        testMoveManager(managerDefault,15,10);
        testMoveManager(managerCustom,15,15);
        testMoveManager(managerCustom,10,10);
    }

    private void testMoveManager(MovieManager manager, int testMoviesLength, int expectedMoviesLength)
    {
        Movie[] testMovies = new Movie[testMoviesLength];

        for (int i = 0; i < testMoviesLength; i++) {
            Movie movie = new Movie();
            movie.setTitle("Фильм" + i);
            testMovies[i] = movie;
        }

        doReturn(testMovies).when(repository).findAll();

        Movie[] expectedMovies = new Movie[expectedMoviesLength];

        for(int i =0, j = (testMoviesLength-1); i < expectedMoviesLength; i++, j-- )
        {
            expectedMovies[i] = testMovies[j];
        }

        Movie[] actualMovies = manager.getLastMovies();
        assertArrayEquals(expectedMovies,actualMovies);
    }

    @Test
    public void moveManager_addMovie() {
        var movie = new Movie();
        managerDefault.addMovie(movie);
        verify(repository).save(movie);
    }

}
