package com.repository;

import com.model.Flight;
import com.model.Passenger;
import com.model.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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
    public List<Plane> oldPlanes() {
        LocalDate localDate = LocalDate.now().minusYears(20);
        Date date = java.sql.Date.valueOf(localDate);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Plane> q = cb.createQuery(Plane.class);
        Root<Plane> root = q.from(Plane.class);
        q.select(root);
        q.where(cb.lessThanOrEqualTo(root.get("yearProduced"), date));
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public List<Plane> regularPlanes(int year) {
        LocalDate localDate1 = LocalDate.of(year, 1, 1);
        Date startDate = java.sql.Date.valueOf(localDate1);

        LocalDate localDate2 = LocalDate.of(year, 12, 31);
        Date endDate = java.sql.Date.valueOf(localDate2);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Flight>root = query.from(Flight.class);
        Join<Plane, Flight> planeFlightJoin = root.join("plane");
        planeFlightJoin.on(criteriaBuilder.between(planeFlightJoin.get("dateFlight"), startDate, endDate));
        query.select(root.get("id"));
        List<Long> longList = entityManager.createQuery(query).getResultList();
       return null;
    }
}
