package com.service;

import com.model.Filter;
import com.model.Flight;
import com.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight save(Flight flight) {
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
        return null;
    }

    @Override
    public List<Flight> mostPopularTo() {
        return null;
    }

    @Override
    public List<Flight> mostPopularFrom() {
        return null;
    }
}
