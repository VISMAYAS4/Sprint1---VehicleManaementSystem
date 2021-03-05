package sprint1.example.customer.module.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;


public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findCustomerByFirstName(String firstName);
//
//	List<Customer> findByVehicle(String type);



	//public List<Customer> viewAllCustomersByType(Vehicle vehicle);
}