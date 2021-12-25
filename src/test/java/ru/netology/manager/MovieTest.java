package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void MovieTestGetSet() {
        Movie movie = new Movie("Фильм");
        String title = "Фильм1";
        String genre = "ужасы";
        String url = "https://localhost/1.jpg";

        assertEquals("Фильм", movie.getTitle());
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setUrlPoster(url);

        assertEquals(title, movie.getTitle());
        assertEquals(genre, movie.getGenre());
        assertEquals(url, movie.getUrlPoster());
    }

}
