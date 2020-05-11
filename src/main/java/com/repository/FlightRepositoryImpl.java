package com.repository;

import com.service.filtering.Filter;
import com.model.Flight;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Flight save(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    @Override
    public Flight delete(Long id) {
        Flight flight = findById(id);
        entityManager.detach(flight);
        return flight;
    }

    @Override
    public Flight findById(Long id) {
        return entityManager.find(Flight.class, id);
    }

    @Override
    public List<Flight> flightsByDate(Filter filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> q = cb.createQuery(Flight.class);
        Root<Flight> root = q.from(Flight.class);
        q.select(root);
        q.where(cb.between(root.get(filter.getFilteredField()), filter.getStartDate(), filter.getEndDate()));
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<Flight> mostPopularTo() {
        return null;
    }

    @Override
    public List<Flight> mostPopularFrom() {
        return null;
    }
}
