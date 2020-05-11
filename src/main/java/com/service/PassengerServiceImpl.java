package com.service;

import com.model.Flight;
import com.model.Passenger;
import com.repository.FlightRepository;
import com.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;
    private FlightRepository flightRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, FlightRepository flightRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public Passenger save(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerRepository.update(passenger);
    }

    @Override
    public Passenger delete(Long id) {
        return passengerRepository.delete(id);
    }

    @Override
    public Passenger findById(Long id) {
        return passengerRepository.findById(id);
    }

    @Override
    public Set<Passenger> regularPassengers(int year) {
        return null;
    }
}
