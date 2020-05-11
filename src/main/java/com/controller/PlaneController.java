package com.controller;

import com.model.Plane;
import com.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlaneController {
    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "savePlane", produces = "application/json")
    public @ResponseBody
    Plane save(@RequestBody Plane plane) {
        return planeService.save(plane);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePlane", produces = "application/json")
    public @ResponseBody Plane update(@RequestBody Plane plane) {
        return planeService.update(plane);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePlane", produces = "application/json")
    public @ResponseBody Plane delete( @RequestBody Long id) {
        return planeService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "findPlane", produces = "application/json")
    public @ResponseBody Plane findById(@RequestBody Long id) {
        return planeService.findById(id);
    }
}
