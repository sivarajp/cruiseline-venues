package com.cruiseline.venue.model;

import java.io.Serializable;

/**
 * Created by a.c.parthasarathy
 */
public class ConsumerModel implements Serializable {

    private static final long serialVersionUID = -6641983907598420960L;

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String reservationName;
    private long id;
}
