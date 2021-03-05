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
import org.springframework.web.bind.annotation.ResponseStatus;

import sprint1.example.customer.module.controller.BookingController;
import sprint1.example.customer.module.controller.VehicleController;
import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;
import sprint1.example.customer.module.exceptions.CustomerNotFoundException;
import sprint1.example.customer.module.repos.IBookingRepository;
import sprint1.example.customer.module.repos.ICustomerRepository;
import sprint1.example.customer.module.repos.IVehicleRepository;

@Service
public class CustomerServices {
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IVehicleRepository vehicleRepository;
	
	
	@Autowired
	VehicleController vehicleController;
	
	@Autowired
	BookingController bookingController;
	
	@Autowired
	BookingServices bookingServices;
	
	@Autowired
	IBookingRepository bokingRepository;
	
	//Add customers

	public Customer addCustomer(@RequestBody Customer c)
	{
	
		Customer customer = customerRepository.findCustomerByFirstName(c.getFirstName());
			
			if(customer == null)
			{
				customerRepository.save(c);
			}
			else
				throw new CustomerNotFoundException("customer "+ c.getFirstName() + " already exist...");
			return customer;
	}
	
	//findCustomer method
	public Customer findCustomer(@PathVariable("id") int id)
	{
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
	}
	
	//Update customers
	@Transactional
	public Customer updateCustomer(@RequestBody Customer customer) {

		Customer c = findCustomer(customer.getCustomerId());
		c.setEmailId(customer.getEmailId());
		return c;
	
	}
	
	
	//viewAllCustomers
	public List<Customer> viewCustomers()
	{
		return customerRepository.findAll();
	}
	
	
	
//	public List<Customer> viewAllCustomers(String type) {
//		
//		
//		
//		Vehicle vehicle = vehicleController.findVehicleByType(type);
//		List<Customer> list = customerRepository.findByVehicle(type);
//		return list;
//		
//	}
//	
//	
	//finding customersById
		public ResponseEntity<Customer> viewCustomerById(int id) {
			
			ResponseEntity<Customer> re = null;
			
			Optional<Customer> customer = customerRepository.findById(id);
			Customer c = null;
			if(customer.isPresent()) {
				c = customer.get();
				re = new ResponseEntity<>(c, HttpStatus.OK);
			}
			else {
				re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return re;
		}	
		
	
	//RemoveCustomers
	public void deleteCustomer(int id)
	{
		Optional<Customer> customer = customerRepository.findById(id);
		Customer c = null;
		if(customer.isPresent())
		{
			c = customer.get(); 
			customerRepository.delete(c);
		}	
	}

	

}
