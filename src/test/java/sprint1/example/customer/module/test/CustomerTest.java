package sprint1.example.customer.module.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.services.CustomerServices;


@SpringBootTest
class CustomerTest {
	
	Customer customer;
	
	@Autowired 
	CustomerServices customerService;
	

	//@Test
	public void testAddCustomers() {

		Customer customer = new Customer("suzy", "b", "suzb8@gmail.com", "9874561230", "Hyderabad");
		Customer c = customerService.addCustomer(customer);
		System.out.println(c);
	}
	
	@Test
	public void testUpdateCustomer() {
		
		Customer customer = new Customer(8, "suzy", "b", "suzb488@gmail.com", "9874561230", "Hyderabad");
		customerService.updateCustomer(customer);
		
	}
	
	//@Test
	public void viewAllCustomers() {
		
		List<Customer> customers = customerService.viewCustomers();
		System.out.println(customers);
		assertEquals(5, customers.size());
	}
	
	//@Test
	public void testDeleteCustomer() {
		
		customerService.deleteCustomer(7);
	}
}
