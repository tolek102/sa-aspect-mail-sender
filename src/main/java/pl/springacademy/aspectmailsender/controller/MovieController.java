package pl.springacademy.aspectmailsender.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.springacademy.aspectmailsender.model.Movie;
import pl.springacademy.aspectmailsender.service.MovieService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies")
    public String getAllMovies(@RequestParam(value = "message", required = false) final String message, final Model model) {
        final List<Movie> allMovies = movieService.getAllMovies();

        if (CollectionUtils.isEmpty(allMovies)) {
            final String errorMessage = "There are no movies in database";
            log.error(errorMessage);
            model.addAttribute("message", errorMessage);
            return "movies";
        }
        model.addAttribute("movies", allMovies);
        model.addAttribute("message", message);
        return "movies";
    }

    @PostMapping("movies/add")
    public String addMovie(@Valid @ModelAttribute final Movie movie, final RedirectAttributes attributes) {
        final Optional<Movie> addedMovie;
        try {
            addedMovie = movieService.addMovie(movie);
        } catch (IllegalStateException e) {
            attributes.addAttribute("message", e.getMessage());
            return "redirect:/movies/add-movie";
        }

        if (addedMovie.isEmpty()) {
            final String errorMessage = String.format("Movie with id %d already exist", movie.getId());
            attributes.addAttribute("message", errorMessage);
            return "redirect:/movies/add-movie";
        }
        attributes.addAttribute("message", "Movie with Id : '" + movie.getId() + "' was added successfully!");
        return "redirect:/movies/add-movie";
    }

    @GetMapping("movies/add-movie")
    public String addMovie(@RequestParam(value = "message", required = false) final String message, final Model model) {
        final List<Movie> allMovies = movieService.getAllMovies();

        model.addAttribute("message", message);
        model.addAttribute("movies", allMovies);
        model.addAttribute("newMovie", new Movie());
        return "addMovie";
    }


}
