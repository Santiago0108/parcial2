package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.dto.VehicleDTO;
import co.edu.escuelaing.cvds.lab7.model.Vehicle;
import co.edu.escuelaing.cvds.lab7.model.VehicleClass;
import java.util.List;

public interface VehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicleById(String vehicleId);
    List<VehicleDTO> getAllVehicles();

    VehicleDTO updateVehicle(String vehicleId, VehicleDTO updatedVehicle);

    void deleteVehicle(String vehicleId);

    VehicleDTO updateVehicleField(String vehicleId, VehicleDTO updatedVehicle);
}
