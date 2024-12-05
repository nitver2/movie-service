package com.tbf.movie.repository;

import com.tbf.movie.entity.Movie;
import com.tbf.movie.entitymapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Movie> findMoviesByFilters(String city, String title, String language, String genre) {
        String query = "SELECT m.movie_id, m.title, m.language, m.genre, m.duration, m.poster_url, m.trailer_url, m.date " +
                "FROM movie m " +
                "JOIN show s ON m.movie_id = s.movie_id " +
                "JOIN theater t ON s.theater_id = t.theater_id " +
                "JOIN city c ON t.city_id = c.city_id " +
                "WHERE c.name = :city " +
                "AND (:title IS NULL OR m.title = :title) " +
                "AND (:language IS NULL OR m.language = :language) " +
                "AND (:genre IS NULL OR m.genre = :genre)";

        Map<String, Object> params = new HashMap<>();
        params.put("city", city);
        params.put("title", title);
        params.put("language", language);
        params.put("genre", genre);
        return namedParameterJdbcTemplate.query(query, params, new MovieRowMapper());
    }

    public boolean addMovie(Movie movie) {
        String query = "INSERT INTO movie (title, language, duration, genre, poster_url, trailer_url, date) " +
                "VALUES (:title, :language, :duration, :genre, :poster_url, :trailer_url, :date)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", movie.getTitle());
        params.addValue("language", movie.getLanguage());
        params.addValue("duration", movie.getDuration());
        params.addValue("genre", movie.getGenre());
        params.addValue("poster_url", movie.getPoster_url());
        params.addValue("trailer_url", movie.getTrailer_url());
        params.addValue("date", movie.getDate());
        return namedParameterJdbcTemplate.update(query, params) != 0;
    }

}
