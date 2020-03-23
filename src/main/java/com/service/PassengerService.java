package com.service;

import com.model.Passenger;

import java.util.Set;

public interface PassengerService {

    Passenger save(Passenger passenger);

    Passenger update(Passenger passenger);

    Passenger delete(Long id);

    Passenger findById(Long id);

    Set<Passenger> regularPassengers (int year);
}
