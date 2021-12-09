package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieTest {

    @Test
    public void MovieTestGetSet()
    {
        Movie movie = new Movie();
        String title = "Фильм";
        String genre = "ужасы";
        String url = "https://localhost/1.jpg";

        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setUrlPoster(url);

        assertEquals(title, movie.getTitle());
        assertEquals(genre, movie.getGenre());
        assertEquals(url, movie.getUrlPoster());
    }

}
