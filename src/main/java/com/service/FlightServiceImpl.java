package com.service;

import com.model.Passenger;
import com.model.Plane;
import com.service.filtering.Filter;
import com.model.Flight;
import com.repository.FlightRepository;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;
    private PlaneService planeService;
    private PassengerService passengerService;

    public FlightServiceImpl(FlightRepository flightRepository, PlaneService planeService, PassengerService passengerService) {
        this.flightRepository = flightRepository;
        this.planeService = planeService;
        this.passengerService = passengerService;
    }

    @Override
    @Transactional
    public Flight save(Flight flight) {
//        flight.setPlane(getMappingPlaneById(flight.getPlane().getId()));
//        flight.setPassengers(getMappingPassengersById(flight.getPassengers()));
        return flightRepository.save(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return flightRepository.update(flight);
    }

    @Override
    public Flight delete(Long id) {
        return flightRepository.delete(id);
    }

    @Override
    public Flight findById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> flightsByDate(Filter filter) {
//        List<Flight> flights = flightRepository.flightsByDate(filter);
//        for (Flight flight : flights) {
//            Hibernate.initialize(flight.getPlane());
//            Hibernate.initialize(flight.getPassengers());
//        }
        return flightRepository.flightsByDate(filter);
    }

    @Override
    public List<Flight> mostPopularTo() {
        return flightRepository.mostPopularTo();
    }

    @Override
    public List<Flight> mostPopularFrom() {
        return null;
    }

    @Transactional
    public Plane getMappingPlaneById(Long id) {
        return planeService.findById(id);
    }

    @Transactional
    public Set<Passenger> getMappingPassengersById(Set<Passenger> passengers) {
        Set<Passenger> passengerSet = new HashSet<>();
        for (Passenger passenger : passengers) {
                passengerSet.add(passengerService.findById(passenger.getId()));
        }
        return passengerSet;
    }
}
