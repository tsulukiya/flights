package com.repository;

import com.model.Passenger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Repository
public class PassengerRepositoryImpl implements PassengerRepository {
    @PersistenceContext
    private EntityManager entityManager;

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
        return entityManager.find(Passenger.class, id);
    }

    @Override
    public Set<Passenger> regularPassengers(int year) {
        return null;
    }
}
