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
import javax.persistence.criteria.*;
import java.util.ArrayList;
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
        Predicate predicate = cb.between(root.get(filter.getFilteredField()), filter.getStartDate(), filter.getEndDate());
        //Predicate predicate1 = cb.equal(root.get(filter.getFilteredField()), filter.getDate());
        //if (filter.)
        q.select(root);
        q.where(predicate);
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<Flight> mostPopularTo() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> query = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> root = query.from(Flight.class);
        query.select(root);
        query.orderBy(criteriaBuilder.desc(root.get("cityTo")));
        //query.groupBy(criteriaBuilder.count(root.get("id")));

        List<Flight>flightList = entityManager.createQuery(query).getResultList();
        System.out.println(flightList.size());

        for (Flight flight : flightList) {
            System.out.println(flight.toString());
        }
        return flightList;
    }

    @Override
    public List<Flight> mostPopularFrom() {
        return null;
    }
}
