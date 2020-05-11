package com.repository;

import com.service.filtering.Filter;
import com.model.Flight;

import java.util.List;

public interface FlightRepository {

    Flight save(Flight flight);

    Flight update(Flight flight);

    Flight delete(Long id);

    Flight findById(Long id);

    List<Flight> flightsByDate(Filter filter);

    List<Flight> mostPopularTo();

    List<Flight> mostPopularFrom();

}
