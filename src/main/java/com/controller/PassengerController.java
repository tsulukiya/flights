package com.controller;

import com.model.Passenger;
import com.model.dto.PassengerDTO;
import com.service.PassengerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET, value = "findRegularPassenger", produces = "application/json")
    public @ResponseBody
    List<PassengerDTO> regularPassengers(int year) {
        List<PassengerDTO>passengerDTOList = new ArrayList<>();
        List<Passenger>passengerList = passengerService.regularPassengers(year);
        for (Passenger passenger : passengerList) {
            PassengerDTO passengerDTO = new PassengerDTO();
            passengerDTO.setId(passenger.getId());
            passengerDTO.setDateOfBirth(passenger.getDateOfBirth());
            passengerDTO.setLastName(passenger.getLastName());
            passengerDTO.setNationality(passenger.getNationality());
            passengerDTO.setPassportCode(passenger.getPassportCode());
            passengerDTOList.add(passengerDTO);
        }
        return passengerDTOList;
    }
}