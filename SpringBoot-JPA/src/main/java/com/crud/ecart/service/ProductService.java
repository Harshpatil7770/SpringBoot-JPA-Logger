package com.crud.ecart.service;

import java.util.List;
import java.util.Optional;

import com.crud.ecart.model.Product;

public interface ProductService {

	Product addNewProduct(Product product);

	String addNewListOfProduct(List<Product> products);

	Product UpdateProduct(Product product);

	void deleteProduct(int productId);

	List<Product> fetchAllProducts();

	Optional<Product> fetchProductById(int productId);

	List<Product> fetchProductByCategoryName(String categoryName);

	List<Product> fetchProductByBrandName(String brandName);

	List<Product> filterbyPriceRange(double minPrice, double maxPrice);

}
