package com.repository;

import com.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Set;

@Repository
@Transactional
public class PlaneRepositoryImpl implements PlaneRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String sqlQueryFindById = "from Plane where id =:code";

    @Override
    public Plane save(Plane plane) {
        entityManager.persist(plane);
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
        Query query = entityManager.createQuery(sqlQueryFindById);
        query.setParameter("code", id);
        Plane plane = (Plane) query.getSingleResult();
        return plane;
    }

    @Override
    public Set<Plane> regularPlanes(int year) {
        
        return null;
    }
}
