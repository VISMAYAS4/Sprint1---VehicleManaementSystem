package sprint1.example.customer.module.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {
	
	}
	
	public CustomerNotFoundException(String message){
		super(message);
	}
}