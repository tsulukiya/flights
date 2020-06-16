package com.repository;

import com.model.Passenger;
import com.service.filtering.Filter;
import com.model.Flight;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepositoryImpl implements FlightRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static final String SQL_MOST_POPULAR_TO =
            "SELECT FLIGHT.*\n" +
                    "FROM FLIGHT\n" +
                    "LEFT JOIN (\n" +
                    "    SELECT CITY_TO, COUNT(FLIGHT_ID) rnk\n" +
                    "    FROM FLIGHT\n" +
                    "    GROUP BY CITY_TO\n" +
                    ") city_rnk ON FLIGHT.CITY_TO = city_rnk.CITY_TO\n" +
                    "ORDER BY city_rnk.rnk DESC";

    private static final String SQL_MOST_POPULAR_FROM =
            "SELECT FLIGHT.*\n" +
                    "FROM FLIGHT\n" +
                    "LEFT JOIN (\n" +
                    "    SELECT CITY_FROM, COUNT(FLIGHT_ID) rnk\n" +
                    "    FROM FLIGHT\n" +
                    "    GROUP BY CITY_FROM\n" +
                    ") city_rnk ON FLIGHT.CITY_FROM = city_rnk.CITY_FROM\n" +
                    "ORDER BY city_rnk.rnk DESC";


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
        Predicate predicate = cb.between(root.get(filter.getFilteredField()), filter.getStartDate(), filter.getEndDate());
        //Predicate predicate1 = cb.equal(root.get(filter.getFilteredField()), filter.getDate());
        q.select(root);
        q.where(predicate);
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<Flight> mostPopularTo() {
        Query query = entityManager.createQuery(SQL_MOST_POPULAR_TO);
        List<Flight> flights = query.getResultList();
        return flights;
    }

    @Override
    public List<Flight> mostPopularFrom() {
        Query query = entityManager.createQuery(SQL_MOST_POPULAR_FROM);
        List<Flight> flights = query.getResultList();
        return flights;
    }
}
