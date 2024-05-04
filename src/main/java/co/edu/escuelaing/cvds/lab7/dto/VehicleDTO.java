package co.edu.escuelaing.cvds.lab7.dto;

import co.edu.escuelaing.cvds.lab7.model.VehicleClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private String id;
    @JsonProperty("class")
    private VehicleClass clase;
    private String manufacturer;
    private String model;
    private Short year; // Changed from String to Integer
    private String type;
    private Integer price_cents;
    private String color;


}
