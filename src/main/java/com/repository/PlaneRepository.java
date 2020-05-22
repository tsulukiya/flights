package com.repository;

import com.model.Plane;

import java.util.List;
import java.util.Set;

public interface PlaneRepository {

    Plane save(Plane plane);

    Plane update(Plane plane);

    Plane delete(Long id);

    Plane findById(Long id);

    List<Plane> regularPlanes(int year);

    List<Plane> oldPlanes();
}
