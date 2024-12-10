package site.rion.Ecommerce.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import site.rion.Ecommerce.model.Product;
import site.rion.Ecommerce.repository.ProductRepository;

@Service
public class ProductService
{
	private ProductRepository productRepo;
	
	
	public ProductService(ProductRepository productRepo)
	{
		this.productRepo = productRepo;
	}
	
	
	public List<Product> getAll()
	{
		return productRepo.findAll();
	}
	
	
	public Page<Product> getPage(int page)
	{
		return productRepo.findAll( PageRequest.of(page-1, 7) ); // This is JpaRepository. It can return Page.
	}
}