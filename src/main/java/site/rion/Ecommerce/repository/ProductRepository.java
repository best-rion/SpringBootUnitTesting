package site.rion.Ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.rion.Ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
	public Page<Product> findAll(Pageable p);
}