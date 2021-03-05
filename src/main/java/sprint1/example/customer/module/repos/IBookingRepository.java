package sprint1.example.customer.module.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sprint1.example.customer.module.entities.Booking;
import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer>{

	public List<Booking> findByCustomer(Customer customer);

	public List<Booking> findByVehicle(Vehicle vehicle);

	public List<Booking> findByBookingDate(LocalDate bDate);
}

