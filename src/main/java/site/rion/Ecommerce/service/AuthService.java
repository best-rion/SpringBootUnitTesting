package site.rion.Ecommerce.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import site.rion.Ecommerce.dto.SignupForm;
import site.rion.Ecommerce.model.Customer;
import site.rion.Ecommerce.repository.CustomerRepository;

@Service
public class AuthService
{
	CustomerRepository customerRepo;
	PasswordEncoder encoder;
	
	public AuthService(CustomerRepository customerRepo, PasswordEncoder encoder)
	{
		this.customerRepo = customerRepo;
		this.encoder = encoder;
	}
	
	public Boolean save(SignupForm form)
	{
		if ( !form.getPassword().equals(form.getConfirm_password()) )
		{
			return false;
		}
		
		Customer newCustomer = new Customer();
		newCustomer.setEmail(form.getEmail());
		newCustomer.setPassword(encoder.encode(form.getPassword()));
		newCustomer.setName("Hossain");
		newCustomer.setAuthority("CUSTOMER");
		
		customerRepo.save(newCustomer);
		return true;
	}
}