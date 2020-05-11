package com.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PASSENGER")
public class Passenger {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("nationality")
    private String nationality;
    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;
    @JsonProperty("passportCode")
    private String passportCode;
    @JsonProperty("flights")
    private Set<Flight> flights = new HashSet<>();

    public Passenger() {
    }

    public Passenger(String lastName, String nationality, Date dateOfBirth, String passportCode, Set<Flight> flights) {
        this.lastName = lastName;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passportCode = passportCode;
        this.flights = flights;
    }

    public Passenger(Long id, String lastName, String nationality, Date dateOfBirth, String passportCode, Set<Flight> flights) {
        this.id = id;
        this.lastName = lastName;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.passportCode = passportCode;
        this.flights = flights;
    }

    @Id
    @SequenceGenerator(name = "PASS_SEQ", sequenceName = "PASSENGER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASS_SEQ")
    @Column(name = "ID")
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


    @ManyToMany(mappedBy = "passengers", fetch = FetchType.LAZY)
    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportCode='" + passportCode + '\'' +
                ", flights=" + flights +
                '}';
    }
}
