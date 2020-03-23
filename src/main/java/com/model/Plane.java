package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PLANE")
public class Plane {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("model")
    private String model;
    @JsonProperty("code")
    private String code;
    @JsonProperty("yearProduced")
    private Date yearProduced;
    @JsonProperty("avgFuelConsumption")
    private Double avgFuelConsumption;

    public Plane() {
    }

    public Plane(String model, String code, Date yearProduced, Double avgFuelConsumption) {
        this.model = model;
        this.code = code;
        this.yearProduced = yearProduced;
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public Plane(Long id, String model, String code, Date yearProduced, Double avgFuelConsumption) {
        this.id = id;
        this.model = model;
        this.code = code;
        this.yearProduced = yearProduced;
        this.avgFuelConsumption = avgFuelConsumption;
    }

    public Plane(Long id, String model, String code, Double avgFuelConsumption) {
        this.id = id;
        this.model = model;
        this.code = code;
        this.avgFuelConsumption = avgFuelConsumption;
    }

    @Id
    @SequenceGenerator(name = "PL_SEQ", sequenceName = "PLANE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PL_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "MODEL_PLANE")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "YEAR_PRODUCED")
    public Date getYearProduced() {
        return yearProduced;
    }

    public void setYearProduced(Date yearProduced) {
        this.yearProduced = yearProduced;
    }

    @Column(name = "AVG_FUEL_CONSUMPTION")
    public Double getAvgFuelConsumption() {
        return avgFuelConsumption;
    }

    public void setAvgFuelConsumption(Double avgFuelConsumption) {
        this.avgFuelConsumption = avgFuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(id, plane.id) &&
                Objects.equals(model, plane.model) &&
                Objects.equals(code, plane.code) &&
                Objects.equals(yearProduced, plane.yearProduced) &&
                Objects.equals(avgFuelConsumption, plane.avgFuelConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, code, yearProduced, avgFuelConsumption);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", code='" + code + '\'' +
                ", yearProduced=" + yearProduced +
                ", avgFuelConsumption=" + avgFuelConsumption +
                '}';
    }
}
