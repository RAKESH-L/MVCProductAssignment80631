package com.spring.main.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.main.model.Product;

@Component
public class ProductDB {
	
	private NamedParameterJdbcTemplate jdbc;
	
	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		String sql="select * from product";
		return jdbc.query(sql, new A());
		
	}

	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("name", product.getName());
		map.put("description", product.getDescription());
		map.put("category", product.getCategory());
		map.put("price", product.getPrice());
		
		String sql="insert into product(name,description,category,price)" 
						+ "values (:name, :description, :category, :price)";
		jdbc.update(sql, map); 
	}

	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		Map<String,Integer> map= new HashMap<>();
		map.put("id", id);
		String sql = "delete from product where id=:id";
		jdbc.update(sql, map);
	}

	public void processEdit(Product product) {
		// TODO Auto-generated method stub 
		Map<String,Object> map = new HashMap<>();
		map.put("id", product.getId());
		map.put("name", product.getName());
		map.put("description", product.getDescription());
		map.put("category", product.getCategory());
		map.put("price", product.getPrice());
		
		String sql="update product SET name=:name,description=:description,category=:category,"
				+ "price=:price where id=:id";
		jdbc.update(sql, map);
	}	
}

class A implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setId(rst.getInt("id"));
		p.setName(rst.getString("name"));
		p.setDescription(rst.getString("description"));
		p.setCategory(rst.getString("category"));
		p.setPrice(rst.getDouble("price"));
		
		return p;
	}
	
}





