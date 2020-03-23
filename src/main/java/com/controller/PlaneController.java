package com.controller;

import com.model.Plane;
import com.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlaneController {
    @Autowired
    private PlaneService planeService;

    @RequestMapping(method = RequestMethod.POST, value = "savePlane", produces = "application/json")
    public @ResponseBody
    Plane save(Plane plane) {
        return planeService.save(plane);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePlane", produces = "application/json")
    public @ResponseBody Plane update(Plane plane) {
        return planeService.update(plane);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePlane", produces = "application/json")
    public @ResponseBody Plane delete(Long id) {
        return planeService.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "findPlane", produces = "application/json")
    public @ResponseBody Plane findById(Long id) {
        return planeService.findById(id);
    }
}
