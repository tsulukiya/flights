package com.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FLIGHT")
public class Flight {
    private Long id;
    private Plane plane;
    private Set<Passenger> passengers = new HashSet<>();
    private Date dateFlight;
    private String cityFrom;
    private String cityTo;

    public Flight() {
    }

    public Flight(Plane plane, Set<Passenger> passengers, Date dateFlight, String cityFrom, String cityTo) {
        this.plane = plane;
        this.passengers = passengers;
        this.dateFlight = dateFlight;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    public Flight(Long id, Plane plane, Set<Passenger> passengers, Date dateFlight, String cityFrom, String cityTo) {
        this.id = id;
        this.plane = plane;
        this.passengers = passengers;
        this.dateFlight = dateFlight;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Id
    @SequenceGenerator(name = "FL_SEQ", sequenceName = "FLIGHT_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FL_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PLANE_FK")
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "PASSENGER", joinColumns = {@JoinColumn(referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID")})
    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Column(name = "DATE_FLIGHT")
    public Date getDateFlight() {
        return dateFlight;
    }

    public void setDateFlight(Date dateFlight) {
        this.dateFlight = dateFlight;
    }

    @Column(name = "CITY_FROM")
    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    @Column(name = "CITY_TO")
    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) &&
                Objects.equals(plane, flight.plane) &&
                Objects.equals(passengers, flight.passengers) &&
                Objects.equals(dateFlight, flight.dateFlight) &&
                Objects.equals(cityFrom, flight.cityFrom) &&
                Objects.equals(cityTo, flight.cityTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plane, passengers, dateFlight, cityFrom, cityTo);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", plane=" + plane +
                ", passengers=" + passengers +
                ", dateFlight=" + dateFlight +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                '}';
    }
}
