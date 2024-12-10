package site.rion.Ecommerce.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import site.rion.Ecommerce.model.Product;
import site.rion.Ecommerce.service.ProductService;

@Controller
public class HomeController
{
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String home(Model model)
	{
		Page<Product> productPage = productService.getPage(1);
		model.addAttribute("productPage", productPage);
		
		
		int pageSize = productPage.getTotalPages();
        if (pageSize > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, pageSize).boxed().collect(Collectors.toList()); // This just does 1,2,3,.....,pageSize
            model.addAttribute("pageNumbers", pageNumbers);
        }
        
  
		return "home.html";
	}
}