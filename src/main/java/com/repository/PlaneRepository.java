package com.repository;

import com.model.Plane;

import java.util.Set;

public interface PlaneRepository {

    Plane save(Plane plane);

    Plane update(Plane plane);

    Plane delete(Long id);

    Plane findById(Long id);

    Set<Plane> regularPlanes(int year);
}
