package sprint1.example.customer.module.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;
import sprint1.example.customer.module.repos.ICustomerRepository;
import sprint1.example.customer.module.repos.IVehicleRepository;


@Service
public class VehicleServices {
	
	@Autowired
	IVehicleRepository vehicleRepository;
	
	
	public void addVehicle(@RequestBody Vehicle v)
	{
		vehicleRepository.save(v);
	}
	
	
	public List<Vehicle> viewVehicles()
	{
		return vehicleRepository.findAll();
	}
	
	
	public Vehicle findVehicleByType(String type){
		
		Vehicle vehicle = vehicleRepository.findVehicleByType(type);
		return vehicle;
	}
	


}
