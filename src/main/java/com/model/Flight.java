package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FLIGHT")
public class Flight {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("plane")
    private Plane plane;
    @JsonProperty("passengers")
    private Set<Passenger> passengers = new HashSet<>();
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("dateFlight")
    private Date dateFlight;
    @JsonProperty("cityFrom")
    private String cityFrom;
    @JsonProperty("cityTo")
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

    public Flight(Long id) {
        this.id = id;
    }

    public Flight(Plane plane, String cityFrom, String cityTo) {
        this.plane = plane;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    public Flight(String cityFrom, String cityTo) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Id
    @SequenceGenerator(name = "FL_SEQ", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FL_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PLANE")
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "FLIGHT_PASSENGER",
            joinColumns = {@JoinColumn(name = "FLIGHT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PASSENGER_ID")})
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
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", plane=" + plane +
                ", dateFlight=" + dateFlight +
                ", cityFrom='" + cityFrom + '\'' +
                ", cityTo='" + cityTo + '\'' +
                '}';
    }

}
