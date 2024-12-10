package site.rion.Ecommerce.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import site.rion.Ecommerce.dto.SignupForm;
import site.rion.Ecommerce.repository.CustomerRepository;

@DataJpaTest
class AuthServiceTest {

    @Autowired
    CustomerRepository customerRepo;

    AuthService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AuthService(customerRepo, new BCryptPasswordEncoder());
    }

    @Test
    void returnsFalseWhenPasswordsDoNotMatch() {

        // Given
        SignupForm form = new SignupForm();
        form.setEmail("husayn.buet@gmail.com");
        form.setPassword("password");
        form.setConfirm_password("drowssap");

        // When
        Boolean matches = underTest.save(form);

        // Then
        Assertions.assertThat(matches).isFalse();
    }

    @Test
    void returnsTrueWhenPasswordsMatch() {

        // Given
        SignupForm form = new SignupForm();
        form.setEmail("husayn.buet@gmail.com");
        form.setPassword("password");
        form.setConfirm_password("password");

        // When
        Boolean matches = underTest.save(form);

        // Then
        Assertions.assertThat(matches).isTrue();
    }


    @Test
    void EmailGetsSaved() {

        // Given
        SignupForm form = new SignupForm();
        form.setEmail("husayn.buet@gmail.com");
        form.setPassword("password");
        form.setConfirm_password("password");

        // When
        underTest.save(form);
        Boolean exists = customerRepo.emailExists(form.getEmail());

        // Then
        Assertions.assertThat(exists).isTrue();
    }
}