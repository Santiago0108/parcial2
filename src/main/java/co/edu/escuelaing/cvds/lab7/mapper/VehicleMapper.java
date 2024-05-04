package co.edu.escuelaing.cvds.lab7.mapper;

import co.edu.escuelaing.cvds.lab7.dto.VehicleDTO;
import co.edu.escuelaing.cvds.lab7.model.Vehicle;
import co.edu.escuelaing.cvds.lab7.model.VehicleClass;

public class VehicleMapper {
    public static VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getId(), vehicle.getClase(), vehicle.getManufacturer(), vehicle.getModel(), vehicle.getYear(), vehicle.getType(), vehicle.getPrice_cents(), vehicle.getColor());
    }

    public static Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        return new Vehicle(vehicleDTO.getId(), vehicleDTO.getClase(), vehicleDTO.getManufacturer(), vehicleDTO.getModel(), vehicleDTO.getYear(), vehicleDTO.getType(), vehicleDTO.getPrice_cents(), vehicleDTO.getColor());
    }
}
