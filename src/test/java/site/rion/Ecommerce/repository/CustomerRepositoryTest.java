package site.rion.Ecommerce.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import site.rion.Ecommerce.model.Customer;


@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository underTest;

    @Test
    void checkIfEmailExists() {
        // Given
        Customer customer = new Customer();
        customer.setEmail("hossain.obat@gmail.com");
        customer.setName("Hossain Rion");
        customer.setPassword("password");

        underTest.save(customer);

        // When
        Boolean exists = underTest.emailExists("hossain.obat@gmail.com");

        // Then
        Assertions.assertThat(exists).isTrue();
    }
}