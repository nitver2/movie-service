package com.tbf.movie.controller;

import com.tbf.movie.entity.Seat;
import com.tbf.movie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seat")
public class SeatController {

    @Autowired
    private SeatService SeatService;

    @GetMapping("/{showId}")
    public List<Seat> findAvailableSeatsByShowId(@PathVariable int showId) {
        return SeatService.findAvailableSeatsByShowId(showId);
    }

    @PostMapping({""})
    public boolean addSeat(@RequestBody Seat seat) {
        return SeatService.addSeat(seat);
    }

}
