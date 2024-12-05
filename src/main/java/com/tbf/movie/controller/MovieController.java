package com.tbf.movie.controller;

import com.tbf.movie.entity.Movie;
import com.tbf.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{city}")
    public List<Movie> getMoviesByFilter(@PathVariable String city,
                                         @RequestParam(required = false) String title,
                                         @RequestParam(required = false) String language,
                                         @RequestParam(required = false) String genre) {
        return movieService.findMoviesByFilters(city, title, language, genre);
    }

    @PostMapping({""})
    public boolean addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

}
