package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.main.model.Product;
import com.spring.main.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	@Autowired
	private Product product;
	
	@RequestMapping("/all-products")
	public String showAllProducts(Model model) {
		return "redirect:redirect-product";
	}
	
	@RequestMapping("/delete-product")
	public String deleteProductById(@RequestParam("id") Integer id, Model model) {
		productService.deleteProductById(id);
		return "redirect:redirect-product";	
	}
	
	@RequestMapping("/insert-product")
	public String insertProduct(@RequestParam("pname") String name,
								@RequestParam("pdescription") String description,
								@RequestParam("pcategory") String category,
								@RequestParam("pprice") double price,
								Model model) {
		product.setName(name);
		product.setDescription(description);
		product.setCategory(category);
		product.setPrice(price);
		
		productService.insertEmployee(product);
		
		
		
		return "redirect:redirect-product";
		
	}
	
	@RequestMapping("/redirect-product")
	public String redirect(Model model) {
		product.setName("");
		product.setDescription("");
		product.setCategory("");
		model.addAttribute("product", product);
		
		List<Product> list = productService.fetchAllProducts();
		
		model.addAttribute("list", list);
		return "all-product";
		
	}
	
	@RequestMapping("/edit-product")
	public String updateProduct(@RequestParam("id") Integer id,Model model) {
		
		List<Product> list = 
				productService.fetchAllProducts();
		
		for(Product p: list) {
			if(p.getId() == id) {
				product = p;
				break;
			}
		}
		
		model.addAttribute("flag", "edit");
		model.addAttribute("product", product);
		model.addAttribute("list", list);
		return "all-product";
		
	}
	@RequestMapping("/edit-product-op")
	public String processEdit(@RequestParam("id") Integer id,
							@RequestParam("pname") String name,
							@RequestParam("pdescription") String description,
							@RequestParam("pcategory") String category,
							@RequestParam("pprice") double price,
							Model model) {
		
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		product.setCategory(category);
		product.setPrice(price);
		
		productService.processEdit(product);
		return "redirect:redirect-product";
	}
	
	
}
