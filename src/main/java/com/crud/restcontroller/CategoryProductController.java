package com.crud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Category;
import com.crud.model.Product;
import com.crud.service.CategoryService;
import com.crud.service.ProductService;

@RestController
@RequestMapping("/api")
public class CategoryProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	// For Showing Relationship(One to Many) one category have Multiple Products
	@PostMapping("/categories")
	public Category saveProductCatagory(@RequestBody Category category) {
		Category categories = categoryService.saveCatagory(category);
		List<Product> proList = category.getProductList();
		for (Product product : proList) {
			product.setCategoryId(category.getId());
			productService.saveProduct(product);
		}
		return categories;
	}

	// Get All Categories
	@GetMapping("/catagories")
	public List<Category> getAllCategories() {
		List<Category> categories = categoryService.getAllCategories();
		return categories;
	}

	// Get Category By Id
	@GetMapping("/catagories/{id}")
	public Category getCategoryById(@PathVariable("id") int id) {
		Category category = categoryService.getCategoryById(id);
		return category;
	}

	// Update Category By Id
	@PutMapping("/catagories/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable("id") int id) {
		Category categoryId = categoryService.updateCategoryById(category, id);
		return categoryId;
	}

	// Delete Category By Id
	@DeleteMapping("catagories/{id}")
	public void deleteCategoryById(@PathVariable("id") int id) {

		categoryService.deleteCategoryById(id);
	}

	// ---------------------------------------------------------------------------------------------//
	// Save Product
	@PostMapping("/products")
	public Product saveProduct(Product product) {
		Product product2 = productService.saveProduct(product);
		return product2;
	}

	// Get All the Product
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return productList;

	}

	// Get Product By Id
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		Product product = productService.getProductById(id);
		return product;
	}

	// Update Product By Id
	@PutMapping("/products/{id}")
	public Product updateProductById(@RequestBody Product product, @PathVariable("id") int id) {
		Product product2 = productService.updateProductById(product, id);
		return product2;
	}

	// Delete Product By Id
	@DeleteMapping("/products/{id}")
	public void deleteProductById(@PathVariable("id") int id) {
		productService.deleteProductById(id);
	}

	// For Server Side Pagination Purpose API for Product
	@GetMapping("/getAllProduct")
	public ResponseEntity<Page<Product>> getAllProduct(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "100") Integer pageSize) {
		Page<Product> list = productService.getAllProducts(pageNo, pageSize);
		return new ResponseEntity<Page<Product>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// For Server Side Pagination Purpose API for Category
	@GetMapping("/getAllCategory")
	public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		Page<Category> categories = categoryService.getAllCategories(page, pageSize);
		return ResponseEntity.ok(categories);
	}

}
