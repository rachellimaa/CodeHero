package com.rachellima.codehero.events;

import com.rachellima.codehero.model.Data;
import com.rachellima.codehero.model.Result;

import java.util.List;

public class ResultDataEvent {
    private Data data;

    public ResultDataEvent(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }
}
