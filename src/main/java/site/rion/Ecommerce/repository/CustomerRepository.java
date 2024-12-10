package site.rion.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import site.rion.Ecommerce.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN"+
                    " TRUE ELSE FALSE END"+
                    " FROM CUSTOMER"+
                    " WHERE email = ?1",
            nativeQuery = true
    )
    Boolean emailExists(String email);
    
    Customer findByEmail(String email);
}