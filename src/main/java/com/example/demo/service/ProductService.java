package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// save single product
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}
	
	//save list of products
		public List<Product> saveProducts(List<Product> products) {
			return productRepository.saveAll(products);
		}

	// get list of products
	public List<Product> getProducts() {

		return productRepository.findAll();
	}

	// get single product ById
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	// get Product ByName
	public Product getProductByName(String name) {
		return productRepository.findProductByName(name);
	}

	// delete product ById
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product is deleted" + id;
	}

	// update product by id
	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());

		return productRepository.save(existingProduct);
	}

}
