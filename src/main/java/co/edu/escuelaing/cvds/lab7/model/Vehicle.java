package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@Table(name="VEHICLE")
public class Vehicle {
    /* El campo CLASS contiene 8 elementos: MOTORCYCLE, PASSAGER_CAR, FOUR_TIRE, BUSES, TWO_AXLE, THREE_AXLE, FOUR_AXLE_OR_MORE, MULTI_TRAILER
El campo rating es un número de 1 a 5 estrellas*/
    @Id
    @Column(name = "VEHICLE_ID")
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "VEHICLE_CLASS")
    private VehicleClass clase;
    @Column(name = "VEHICLE_MANUFACTURER")
    private String manufacturer;
    @Column(name = "VEHICLE_MODEL")
    private String model;
    @Min(value = 1000, message = "El año debe tener al menos 4 dígitos")
    @Max(value = 9999, message = "El año no puede tener más de 4 dígitos")
    @Column(name = "VEHICLE_YEAR")
    private Short year; // Changed from String to Integer
    @Column(name = "VEHICLE_TYPE")
    private String type;
    @Column(name = "VEHICLE_PRICE_CENTS")
    private Integer price_cents;
    @Column(name = "VEHICLE_COLOR")
    private String color;

    public Vehicle() {
    }

    public Vehicle(String vehicleId, VehicleClass vehicleClass, String vehicleManufacturer, String vehicleModel, Short vehicleYear, String vehicleType, Integer vehiclePriceCents, String vehicleColor) {
        this.id = vehicleId;
        this.clase = vehicleClass;
        this.manufacturer = vehicleManufacturer;
        this.model = vehicleModel;
        this.year = vehicleYear;
        this.type = vehicleType;
        this.price_cents = vehiclePriceCents;
        this.color = vehicleColor;
    }

    public void setVehicleYear(Short vehicleYear) {
        if (vehicleYear != null && vehicleYear >= 1000 && vehicleYear <= 9999) {
            this.year = vehicleYear;
        } else {
            throw new IllegalArgumentException("El año debe ser un número de 4 dígitos");
        }
    }

}
