package co.edu.escuelaing.cvds.lab7.service.impl;

import co.edu.escuelaing.cvds.lab7.dto.VehicleDTO;
import co.edu.escuelaing.cvds.lab7.mapper.VehicleMapper;
import co.edu.escuelaing.cvds.lab7.model.Vehicle;
import co.edu.escuelaing.cvds.lab7.model.VehicleClass;
import co.edu.escuelaing.cvds.lab7.service.VehicleService;
import co.edu.escuelaing.cvds.lab7.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import co.edu.escuelaing.cvds.lab7.exception.ResourceNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private VehicleRepository VehicleRepository;

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDTO);
        Vehicle savedVehicle =  VehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDTO(savedVehicle);
    }

    @Override
    public VehicleDTO getVehicleById(String vehicleId) {
        Vehicle vehicle = VehicleRepository.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle is not exixsts with given id: " + vehicleId));
        return VehicleMapper.mapToVehicleDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = VehicleRepository.findAll();
        return vehicles.stream().map((vehicle) -> VehicleMapper.mapToVehicleDTO(vehicle)).collect(Collectors.toList());
    }

    @Override
    public VehicleDTO updateVehicle(String vehicleId, VehicleDTO updatedVehicle) {
        Vehicle vehicle = VehicleRepository.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle is not exixsts with given id: " + vehicleId));
        vehicle.setClase(VehicleClass.valueOf(updatedVehicle.getClass().toString()));
        vehicle.setManufacturer(updatedVehicle.getManufacturer());
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setYear(updatedVehicle.getYear());
        vehicle.setType(updatedVehicle.getType());
        vehicle.setPrice_cents(updatedVehicle.getPrice_cents());
        vehicle.setColor(updatedVehicle.getColor());
        Vehicle updatedVehicleObj = VehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDTO(updatedVehicleObj);
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        Vehicle vehicle = VehicleRepository.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle is not exixsts with given id: " + vehicleId));
        VehicleRepository.delete(vehicle);
    }

    @Override
    public VehicleDTO updateVehicleField(String vehicleId, VehicleDTO updatedVehicle) {
        Vehicle vehicle = VehicleRepository.findById(vehicleId).orElseThrow(()->new ResourceNotFoundException("Vehicle is not exixsts with given id: " + vehicleId));
        if(updatedVehicle.getManufacturer() != null){
            vehicle.setManufacturer(updatedVehicle.getManufacturer());
        }
        if(updatedVehicle.getModel() != null){
            vehicle.setModel(updatedVehicle.getModel());
        }
        if(updatedVehicle.getYear() != null){
            vehicle.setYear(updatedVehicle.getYear());
        }
        if(updatedVehicle.getType() != null){
            vehicle.setType(updatedVehicle.getType());
        }
        if(updatedVehicle.getPrice_cents() != null){
            vehicle.setPrice_cents(updatedVehicle.getPrice_cents());
        }
        if(updatedVehicle.getColor() != null){
            vehicle.setColor(updatedVehicle.getColor());
        }
        if(updatedVehicle.getClase() != null){
            vehicle.setClase(updatedVehicle.getClase());
        }
        Vehicle updatedVehicleObj = VehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDTO(updatedVehicleObj);
    }
}
