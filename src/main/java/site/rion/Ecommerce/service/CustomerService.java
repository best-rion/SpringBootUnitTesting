package site.rion.Ecommerce.service;

import org.springframework.stereotype.Service;
import site.rion.Ecommerce.model.Customer;
import site.rion.Ecommerce.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll()
    {
        return customerRepository.findAll();
    }
}
