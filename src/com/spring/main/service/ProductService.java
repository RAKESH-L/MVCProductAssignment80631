package com.spring.main.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.db.ProductDB;
import com.spring.main.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDB productDB;
	
	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
//		Product p1 = new Product(1, "Poco M2 Pro", "8GB", "Mobile", 22000);
//		Product p2 = new Product(2, "Fastrack", "Clock watch", "Watch", 3500);
//		List<Product> list = Arrays.asList(p1,p2);
		
		List<Product> list = productDB.fetchAllProducts();
		return list;
	}

	public void insertEmployee(Product product) {
		// TODO Auto-generated method stub
		productDB.insertProduct(product);
		
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productDB.deleteProductById(id);
	}

	public void processEdit(Product product) {
		// TODO Auto-generated method stub
		productDB.processEdit(product);
	}

}
