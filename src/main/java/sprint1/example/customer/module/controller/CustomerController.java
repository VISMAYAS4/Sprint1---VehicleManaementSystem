package  sprint1.example.customer.module.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;
import sprint1.example.customer.module.repos.ICustomerRepository;
import sprint1.example.customer.module.services.CustomerServices;


@RestController
public class CustomerController {
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	CustomerServices customerServices;
	
	
	@PostMapping("/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCustomer(@RequestBody Customer c) {
		customerServices.addCustomer(c);
	}
	
	@PutMapping("/customer")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public void updateCustomer(@RequestBody Customer c) {
		customerServices.updateCustomer(c);
	}
	
	@GetMapping("/customer")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Customer> viewCustomers() {
		return customerServices.viewCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> viewCustomerById(@PathVariable("id") int id) {
		return customerServices.viewCustomerById(id);
	}
	
	
//	@GetMapping("/customer/{type}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public List<Customer> viewAllCustomers(@PathVariable("type") String type) {
//		return customerServices.viewAllCustomers("bike");
//	}
	
	@DeleteMapping("/customer/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomer(@PathVariable("id") int id) {
		customerServices.deleteCustomer(id);
	}
	
}