package sprint1.example.customer.module.serviceInterface;

import java.time.LocalDate;
import java.util.List;

import sprint1.example.customer.module.entities.Booking;
import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;

public interface IBookingService {
	public Booking addBooking(Booking booking);
	public Booking cancelBooking(Booking b);
	public Booking updateBooking(Booking b);
	public Booking viewBooking(Booking b);
	public List<Booking> viewAllBooking(Customer customer);
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate);
	public List<Booking> viewAllBookingByVehicle(Vehicle vehicle); 
	
}