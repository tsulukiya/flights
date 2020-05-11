package com.repository;

import com.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Repository
public class PlaneRepositoryImpl implements PlaneRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Plane save(Plane plane) {
        entityManager.merge(plane);
        return plane;
    }

    @Override
    public Plane update(Plane plane) {
        entityManager.merge(plane);
        return plane;
    }

    @Override
    public Plane delete(Long id) {
        Plane plane = findById(id);
        entityManager.detach(plane);
        return plane;
    }

    @Override
    public Plane findById(Long id) {
        return entityManager.find(Plane.class, id);
    }

    @Override
    public Set<Plane> regularPlanes(int year) {

        return null;
    }
}
