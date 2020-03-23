package com.controller;

import com.model.Passenger;
import com.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(method = RequestMethod.POST, value = "savePassenger", produces = "application/json")
    public @ResponseBody
    Passenger save(Passenger passenger) {
        return passengerService.save(passenger);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePassenger", produces = "application/json")
    public @ResponseBody Passenger update(Passenger passenger) {
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
