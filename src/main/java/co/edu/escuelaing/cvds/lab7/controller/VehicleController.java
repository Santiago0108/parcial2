package co.edu.escuelaing.cvds.lab7.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.escuelaing.cvds.lab7.service.VehicleService;
import co.edu.escuelaing.cvds.lab7.dto.VehicleDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/vehicles")
public class VehicleController {
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO savedVehicle = vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable("id") String vehicleId) {
        VehicleDTO vehicleDTO = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok(vehicleDTO);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @PutMapping("{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable("id") String vehicleId, @RequestBody VehicleDTO updatedVehicle) {
        VehicleDTO vehicleDTO = vehicleService.updateVehicle(vehicleId, updatedVehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") String vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }

    @PatchMapping("{id}")
    public ResponseEntity<VehicleDTO> updateVehicleField(@PathVariable("id") String vehicleId, @RequestBody VehicleDTO updatedVehicle) {
        VehicleDTO vehicleDTO = vehicleService.updateVehicleField(vehicleId, updatedVehicle);
        return ResponseEntity.ok(vehicleDTO);
    }

}
