package sprint1.example.customer.module.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprint1.example.customer.module.entities.Booking;
import sprint1.example.customer.module.entities.Customer;
import sprint1.example.customer.module.entities.Vehicle;
import sprint1.example.customer.module.exceptions.CustomerNotFoundException;
import sprint1.example.customer.module.exceptions.VehicleNotFoundException;
import sprint1.example.customer.module.repos.IBookingRepository;
import sprint1.example.customer.module.repos.ICustomerRepository;
import sprint1.example.customer.module.repos.IVehicleRepository;
import sprint1.example.customer.module.serviceInterface.IBookingService;

@Service
public class BookingServices implements IBookingService{
	
	@Autowired
	IBookingRepository bookingRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IVehicleRepository vehicleRepository;
	
	Optional<Booking> booking = null;
	
	@Override
	@Transactional
	public Booking addBooking(Booking b) {
		try {
			
			Vehicle vehicle = vehicleRepository.findVehicleByVehicleNumber(b.getVehicle().getVehicleNumber());
			Customer customer = customerRepository.findCustomerByFirstName(b.getCustomer().getFirstName());
			if(vehicle != null) {
				b.setVehicle(vehicle);
			}
			System.out.println(vehicle);
			System.out.println(customer);
			
			if(customer != null ) {
				b.setCustomer(customer);
			}
		}catch(CustomerNotFoundException | VehicleNotFoundException e) {
			e.getMessage();	
		}	
		
		bookingRepository.save(b);
		return b;
	}

	@Override
	public Booking cancelBooking(Booking b) {
		booking = bookingRepository.findById(b.getBookingId());
		Booking b1 = null;
		if(booking.isPresent()) {
			b1 = booking.get();
			bookingRepository.delete(b1);
		}
		return b1;
	}

	@Override
	@Transactional
	public Booking updateBooking(Booking b) {
		Optional<Booking> booking = bookingRepository.findById(b.getBookingId());
		Booking b1 = null;
		if(booking.isPresent()) {
			b1 = booking.get();
			b1.setBookingDescription(b.getBookingDescription());		
		}
		return b1;
	}
	
	@Override
	public List<Booking> viewAllBooking(Customer customer) {
		Customer c = customerRepository.findCustomerByFirstName(customer.getFirstName());
		List<Booking> bookings = bookingRepository.findByCustomer(c);
		return bookings;
		
	}

	@Override
	public List<Booking> viewAllBookingByVehicle(Vehicle v) {
		Vehicle vehicle = vehicleRepository.findVehicleByVehicleNumber(v.getVehicleNumber());
		List<Booking> bookings = bookingRepository.findByVehicle(vehicle);
		return bookings;
	}
	
	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bDate) {
		List<Booking> bookings = bookingRepository.findByBookingDate(bDate);
		return bookings;
	}

	@Override
	public Booking viewBooking(Booking b) {
		Optional<Booking> booking = bookingRepository.findById(b.getBookingId());
		Booking b1 = booking.get();
		return b1;
	}

	
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		return bookings;
	}

}