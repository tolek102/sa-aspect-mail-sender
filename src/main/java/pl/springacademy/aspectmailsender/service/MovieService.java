package pl.springacademy.aspectmailsender.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.springacademy.aspectmailsender.aspect.MailNotification;
import pl.springacademy.aspectmailsender.model.Movie;
import pl.springacademy.aspectmailsender.repository.MovieRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @MailNotification
    public Optional<Movie> addMovie(final Movie newMovie) {
        final Optional<Movie> queriedVideo = findMovieById(newMovie.getId());

        if (queriedVideo.isPresent()) {
            final String errorMessage = String.format("Movie with id %d already exist", newMovie.getId());
            log.error(errorMessage);
            throw new IllegalStateException(errorMessage);
        }

        movieRepository.addMovie(newMovie);
        return Optional.of(newMovie);
    }

    private Optional<Movie> findMovieById(final int id) {
        final List<Movie> movieList = movieRepository.getAllMovies();

        return movieList.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst();
    }
}
