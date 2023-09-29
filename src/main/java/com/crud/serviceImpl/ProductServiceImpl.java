package com.crud.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crud.model.Product;
import com.crud.repositiory.PaginationRepository;
import com.crud.repositiory.ProductRepository;
import com.crud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PaginationRepository paginationRepository;

	@Override
	public Product saveProduct(Product product) {
		Product products = productRepository.save(product);
		return products;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public Product getProductById(int id) {
		Product products = productRepository.findById(id);
		return products;
	}

	@Override
	public Product updateProductById(Product product, int id) {
		Product product2 = productRepository.findById(id);
		product2.setProductId(product.getProductId());
		product2.setProductName(product.getProductName());
		product2.setProductQuantityPerUnit(product.getProductQuantityPerUnit());
		product2.setProductPrice(product.getProductPrice());
		Product products = productRepository.save(product2);
		return products;
	}

	@Override
	public void deleteProductById(int id) {

		productRepository.deleteById(id);

	}

	// For Pagination Purpose
	@Override
	public Page<Product> getAllProducts(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Product> pagedResult = paginationRepository.findAll(paging);
		return pagedResult;
		

	}

}
