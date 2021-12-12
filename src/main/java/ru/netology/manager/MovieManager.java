package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {

    private int lastMoviesLength;
    MovieRepository repository;

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getLastMovies() {
        int tmpLength = lastMoviesLength;
        Movie[] movies = repository.findAll();
        if (movies.length < tmpLength) {
            tmpLength = movies.length;
        }

        Movie[] tmp = new Movie[tmpLength];
        int index = movies.length - 1;
        int endIndex = index - tmpLength;
        int tmpIndex = 0;
        while (index > endIndex) {
            tmp[tmpIndex] = movies[index];
            tmpIndex++;
            index--;
        }
        return tmp;
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
        lastMoviesLength = 10;
    }

    public MovieManager(MovieRepository repository, int lastMoviesLength) {
        this.repository = repository;
        this.lastMoviesLength = lastMoviesLength;
    }
}
