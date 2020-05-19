package com.model;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PASSENGER")
public class Passenger {

    private Long id;
    private String lastName;
    private String nationality;
    private Date dateOfBirth;
    private String passportCode;
    private Set<Flight> flights = new HashSet<>();

    @Id
    @SequenceGenerator(name = "PASSENGER_SEQ", sequenceName = "PASSENGER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSENGER_SEQ")
    @Column(name = "PASSENGER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "NATIONALITY")
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "DATE_OF_BIRTH")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "PASSPORT_CODE")
    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "passengers")
    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id) &&
                Objects.equals(lastName, passenger.lastName) &&
                Objects.equals(nationality, passenger.nationality) &&
                Objects.equals(dateOfBirth, passenger.dateOfBirth) &&
                Objects.equals(passportCode, passenger.passportCode) &&
                Objects.equals(flights, passenger.flights);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, lastName, nationality, dateOfBirth, passportCode, flights);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth.toString() +
                ", passportCode='" + passportCode + '\'' +
                ", flights=" + flights.toString() +
                '}';
    }
}
