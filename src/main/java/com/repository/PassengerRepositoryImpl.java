package com.repository;

import com.model.Flight;
import com.model.Passenger;
import com.model.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    public List<Passenger> regularPassengers(int year) {

        LocalDate localDate1 = LocalDate.of(year, 1, 1);
        Date startDate = java.sql.Date.valueOf(localDate1);
        System.out.println(startDate.toString());

        LocalDate localDate2 = LocalDate.of(year, 12, 31);
        Date endDate = java.sql.Date.valueOf(localDate2);
        System.out.println(endDate.toString());

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = criteriaBuilder.createQuery(Long.class);
        Root<Passenger> root = query.from(Passenger.class);
        Join<Passenger, Flight> passengerFlightJoin = root.join("flights");
        query.select(root.get("id"));
        query.where(criteriaBuilder.between(passengerFlightJoin.get("dateFlight"), startDate, endDate));
        query.groupBy(root.get("id"));
        query.having(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.
                count(passengerFlightJoin.get("id")), 2L));
        List<Long> longList = entityManager.createQuery(query).getResultList();
        List<Passenger>passengerList = new ArrayList<>();

        for (Long aLong : longList) {
            passengerList.add(findById(aLong));
        }
        return passengerList;
    }
}

//    SELECT P.PASSENGER_ID, COUNT(F.FLIGHT_ID)
//        FROM PASSENGER P
//        JOIN FLIGHT_PASSENGER  FP ON P.PASSENGER_ID = FP.ID_PASSENGER
//        JOIN flight F ON f.flight_id = fp.id_flight AND f.date_flight BETWEEN '01.01.2020 00:00:00,000000000 EUROPE/KIEV' AND
//        '31.12.2020 23:59:00,000000000 EUROPE/KIEV'
//        GROUP BY p.passenger_id
//        HAVING COUNT(F.FLIGHT_ID) > 11;
