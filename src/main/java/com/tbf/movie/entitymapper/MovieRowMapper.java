package com.tbf.movie.entitymapper;

import com.tbf.movie.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setMovie_id(rs.getInt("movie_id"));
        movie.setTitle(rs.getString("title"));
        movie.setLanguage(rs.getString("language"));
        movie.setDuration(rs.getInt("duration"));
        movie.setGenre(rs.getString("genre"));
        movie.setPoster_url(rs.getString("poster_url"));
        movie.setTrailer_url(rs.getString("trailer_url"));
        movie.setDate(rs.getObject("date", LocalDateTime.class));
        return movie;
    }
}
