package com.service;

import com.model.Plane;

import java.util.List;

public interface PlaneService {

    Plane save(Plane plane);

    Plane update(Plane plane);

    Plane delete(Long id);

    Plane findById(Long id);

    public List<Plane> oldPlanes();

    List<Plane> regularPlanes(int year);
}
