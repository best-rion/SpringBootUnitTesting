package site.rion.Ecommerce.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import site.rion.Ecommerce.repository.CustomerRepository;

import static org.mockito.Mockito.verify;

class CustomerServiceTest {

    @Mock private CustomerRepository customerRepo;
    private AutoCloseable autoCloseable;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerService(customerRepo);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAll() {

        // When
        underTest.getAll();

        //Then
        verify(customerRepo).findAll();
    }
}