package site.rion.Ecommerce.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import site.rion.Ecommerce.repository.CustomerRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{
	CustomerRepository customerRepo;
	
	public UserDetailsServiceImpl(CustomerRepository customerRepo)
	{
		this.customerRepo = customerRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return customerRepo.findByEmail(email);
	}
	
}