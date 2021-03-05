package sprint1.example.customer.module.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sprint1.example.customer.module.entities.Vehicle;


public interface IVehicleRepository extends JpaRepository<Vehicle, Integer>{

	Vehicle findVehicleByType(String type);
	Vehicle findVehicleByVehicleNumber(String vehicleNumber);


}