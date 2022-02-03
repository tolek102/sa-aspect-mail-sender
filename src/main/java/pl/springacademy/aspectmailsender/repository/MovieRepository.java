package pl.springacademy.aspectmailsender.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pl.springacademy.aspectmailsender.model.Movie;

@Slf4j
@Repository
public class MovieRepository {

    private List<Movie> movieList;

    public MovieRepository() {
        this.movieList = new ArrayList<>();
        movieList.addAll(Arrays.asList(
                Movie.builder().id(1).title("The Shawshank Redemption").yearOfPremiere(1994).director("Frank Darabont").build(),
                Movie.builder().id(2).title("The Godfather").yearOfPremiere(1972).director("Francis Ford Coppola").build(),
                Movie.builder().id(3).title("The Dark Knight").yearOfPremiere(2008).director("Christopher Nolan").build()
        ));
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public void addMovie(final Movie movie) {
        movieList.add(movie);
        log.info("Movie {} was added to list", movie);
    }
}
