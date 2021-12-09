package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int lastMoviesLength;

    public void addMovie(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] getLastMovies() {
        int tmpLength = lastMoviesLength;

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

    public MovieManager() {
        lastMoviesLength = 10;
    }

    public MovieManager(int lastMoviesLength) {
        this.lastMoviesLength = lastMoviesLength;
    }
}
