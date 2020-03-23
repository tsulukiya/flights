package com.repository;

import com.model.Passenger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Set;

@Repository
@Transactional
public class PassengerRepositoryImpl implements PassengerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String sqlQueryFindById = "from Passenger where id =:code";

    @Override
    public Passenger save(Passenger passenger) {
        entityManager.persist(passenger);
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        entityManager.merge(passenger);
        return passenger;
    }

    @Override
    public Passenger delete(Long id) {
        Passenger passenger = findById(id);
        entityManager.detach(passenger);
        return passenger;
    }

    @Override
    public Passenger findById(Long id) {
        Query query = entityManager.createQuery(sqlQueryFindById);
        query.setParameter("code", id);
        return (Passenger) query.getSingleResult();
    }

    @Override
    public Set<Passenger> regularPassengers(int year) {
        return null;
    }
}
