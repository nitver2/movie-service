package com.tbf.movie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Movie implements Serializable {

    private int movie_id;
    private String title;
    private String language;
    private int duration;
    private String genre;
    private String poster_url;
    private String trailer_url;
    private LocalDateTime date;

}
