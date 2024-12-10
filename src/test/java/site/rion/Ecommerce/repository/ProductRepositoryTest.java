package site.rion.Ecommerce.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import site.rion.Ecommerce.model.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;

    @Test
    void It_can_save_product()
    {
        // Given
        Product product = new Product();
        product.setBrand_name("RION");
        product.setProduct_name("ABCD EF 1234");
        product.setPrice(400);
        product.setStock(1);
        product.setPic_url("https://i.pinimg.com/736x/8b/37/a9/8b37a9c0369f7571d777e1887a54de17.jpg");
        underTest.save(product);

        // When
        List<Product> products = underTest.findAll();

        // Then
        Assertions.assertThat(products.size()).isEqualTo(1);
    }
}