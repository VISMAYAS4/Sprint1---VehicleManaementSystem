package sprint1.example.customer.module.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sprint1.example.customer.module.entities.Vehicle;
import sprint1.example.customer.module.repos.IVehicleRepository;
import sprint1.example.customer.module.services.VehicleServices;

@RestController
public class VehicleController {
		
		@Autowired
		IVehicleRepository vehicleRepository;
		
		@Autowired
		VehicleServices VehicleServices;
		
		@PostMapping("/vehicles")
		@ResponseStatus(code = HttpStatus.CREATED)
		public void addVehicle(@RequestBody Vehicle v) {
			VehicleServices.addVehicle(v);
		}
		
		
		@GetMapping("/vehicles")
		@ResponseStatus(code = HttpStatus.OK)
		public List<Vehicle> viewVehicles() {
			return VehicleServices.viewVehicles();
		}
		
		
		@GetMapping("/vehicles/{type}")
		@ResponseStatus(code = HttpStatus.FOUND)
		public Vehicle findVehicleByType(@PathVariable("type") String type){
			
			return vehicleRepository.findVehicleByType(type);
			
		}
}
