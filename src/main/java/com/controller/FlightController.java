package com.controller;

import com.model.Flight;
import com.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    @RequestMapping(method = RequestMethod.POST, value = "saveFlight", produces = "application/json")
    public @ResponseBody
    Flight save(Flight flight) {
        return flightService.save(flight);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateFlight", produces = "application/json")
    public @ResponseBody Flight update(Flight flight) {
        return flightService.update(flight);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteFlight", produces = "application/json")
    public @ResponseBody Flight delete(Long id) {
        return flightService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "findFlight", produces = "application/json")
    public @ResponseBody Flight findById(Long id) {
        return flightService.findById(id);
    }
}
