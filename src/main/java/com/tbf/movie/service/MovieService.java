package com.tbf.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.tbf.movie.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.tbf.movie.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    private MovieRepository movieRepository;

    public boolean addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public List<Movie> findMoviesByFilters(String city, String title, String language, String genre) {
        return movieRepository.findMoviesByFilters(city, title, language, genre);
    }

}
