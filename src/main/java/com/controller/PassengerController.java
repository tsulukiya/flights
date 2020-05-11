package com.controller;

import com.model.Passenger;
import com.service.PassengerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "savePassenger", produces = "application/json")
    public @ResponseBody
    Passenger save(@RequestBody Passenger passenger) {
        return passengerService.save(passenger);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePassenger", produces = "application/json")
    public @ResponseBody Passenger update(@RequestBody Passenger passenger) {
        return passengerService.update(passenger);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePassenger", produces = "application/json")
    public @ResponseBody Passenger delete(Long id) {
        return passengerService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "findPassenger", produces = "application/json")
    public @ResponseBody Passenger findById(Long id) {
        return passengerService.findById(id);
    }
}