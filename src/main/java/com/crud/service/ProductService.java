package com.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.crud.model.Product;

public interface ProductService {

	//Create new Product or Save Product
	public Product saveProduct(Product product);
	
	//Get All the Products 
	public List<Product> getAllProducts();
	
	//Get Product By Id
	public Product getProductById(int id);
	
	//Update Product By Id
	public Product updateProductById(Product product, int id);
	
	//Delele Product By Id
	public void deleteProductById(int id);
	
	//For Server Side Pagination Purpose 
	public Page<Product> getAllProducts(Integer pageNo, Integer pageSize);

}
