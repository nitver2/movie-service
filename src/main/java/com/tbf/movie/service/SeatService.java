package com.tbf.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.tbf.movie.entity.Seat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.tbf.movie.repository.SeatRepository;

import java.util.List;

@Service
public class SeatService {

    private static final Logger logger = LoggerFactory.getLogger(SeatService.class);

    @Autowired
    private SeatRepository movieRepository;

    public boolean addSeat(Seat movie) {
        return movieRepository.addSeat(movie);
    }

    public List<Seat> findAvailableSeatsByShowId(int showId) {
        return movieRepository.findAvailableSeatsByShowId(showId);
    }

}
