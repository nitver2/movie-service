package com.tbf.movie.entitymapper;

import com.tbf.movie.constants.SeatStatus;
import com.tbf.movie.entity.Seat;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatRowMapper implements RowMapper<Seat> {

    @Override
    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Seat seat = new Seat();
        seat.setSeat_id(rs.getInt("seat_id"));
        seat.setHall_id(rs.getString("hall_id"));
        seat.setSeat_no(rs.getString("seat_no"));
        seat.setRow_no(rs.getInt("row_no"));
        seat.setStatus(SeatStatus.fromString((rs.getString("status"))));
        return seat;
    }
}
