package com.repository;

import com.model.Passenger;

import java.util.List;

public interface PassengerRepository {

    Passenger save(Passenger passenger);

    Passenger update(Passenger passenger);

    Passenger delete(Long id);

    Passenger findById(Long id);

    List<Passenger> regularPassengers (int year);
}
