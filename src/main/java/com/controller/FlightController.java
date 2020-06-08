package com.controller;

import com.model.Flight;
import com.service.FlightService;
import com.service.filtering.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "saveFlight", produces = "application/json")
    public @ResponseBody
    Flight save(@RequestBody Flight flight) {
        flightService.save(flight);
        return flightService.save(flight);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateFlight", produces = "application/json")
    public @ResponseBody Flight update(@RequestBody Flight flight) {
        return flightService.update(flight);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFlight", produces = "application/json")
    public @ResponseBody Flight delete(@RequestBody Long id) {
        return flightService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "findFlight", produces = "application/json")
    public @ResponseBody Flight findById(Long id) {
        return flightService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "filteringFlight", produces = "application/json")
    public @ResponseBody
    List<Flight> filteringFlights(@RequestBody Filter filter) {
        return flightService.flightsByDate(filter);
    }

    @RequestMapping(method = RequestMethod.GET, value = "filteringMostPopFlight", produces = "application/json")
    public @ResponseBody
    List<Flight> mostPopularTo() {
        return flightService.mostPopularTo();
    }
}
