package com.tbf.movie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Seat implements Serializable {

    private int seat_id;
    private String hall_id;
    private String seat_no;
    private int row_no;
    private Enum status;
}
