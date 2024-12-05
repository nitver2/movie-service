package com.tbf.movie.repository;

import com.tbf.movie.constants.SeatStatus;
import com.tbf.movie.entity.Seat;
import com.tbf.movie.entitymapper.SeatRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SeatRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Seat> findAvailableSeatsByShowId(int showId) {
        String query = "SELECT ss.id, ss.seat_id, ss.status, s.hall_id, s.seat_no, s.row_no, ss.status " +
                "FROM seat_and_show_mapping ss " +
                "JOIN seat s on ss.seat_id = s.seat_id " +
                "WHERE ss.show_id = :show_id";

        Map<String, Object> params = new HashMap<>();
        params.put("show_id", showId);
        return namedParameterJdbcTemplate.query(query, params, new SeatRowMapper());
    }

    public boolean addSeat(Seat seat) {
        String query = "INSERT INTO seat (hall_id, seat_no, row_no, updated_at) " +
                "VALUES (:hall_id, :seat_no, :row_no, :updated_at)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("hall_id", seat.getHall_id());
        params.addValue("seat_no", seat.getSeat_no());
        params.addValue("row_no", seat.getRow_no());
        params.addValue("updated_at", LocalDateTime.now());
        return namedParameterJdbcTemplate.update(query, params) != 0;
    }

}
