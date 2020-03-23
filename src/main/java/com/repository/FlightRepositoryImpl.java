package com.repository;

import com.model.Filter;
import com.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class FlightRepositoryImpl implements FlightRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String sqlQueryFindById = "from Flight where id =:code";
    @Override
    public Flight save(Flight flight) {
        entityManager.persist(flight);
        return flight;
    }

    @Override
    public Flight update(Flight flight) {
        entityManager.merge(flight);
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
        Query query = entityManager.createQuery(sqlQueryFindById);
        query.setParameter("code", id);
        Flight flight = (Flight) query.getSingleResult();
        return flight;
    }

    @Override
    public List<Flight> flightsByDate(Filter filter) {
        return null;
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
