package com.service;

import com.model.Plane;
import com.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class PlaneServiceImpl implements PlaneService {
    private PlaneRepository planeRepository;

    @Autowired
    public PlaneServiceImpl(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @Override
    public Plane save(Plane plane) {
        plane.setYearProduced(new Date(1978));
        return planeRepository.save(plane);
    }

    @Override
    public Plane update(Plane plane) {
        return planeRepository.update(plane);
    }

    @Override
    public Plane delete(Long id) {
        return planeRepository.delete(id);
    }

    @Override
    public Plane findById(Long id) {
        return planeRepository.findById(id);
    }

    @Override
    public List<Plane> oldPlanes() {
        return planeRepository.oldPlanes();
    }

    @Override
    public List<Plane> regularPlanes(int year) {
        return planeRepository.regularPlanes(year);
    }
}
