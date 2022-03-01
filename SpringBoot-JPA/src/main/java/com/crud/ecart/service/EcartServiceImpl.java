package com.crud.ecart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ecart.dao.BrandDao;
import com.crud.ecart.dao.CategoryDao;
import com.crud.ecart.dao.ProductDao;
import com.crud.ecart.model.Brand;
import com.crud.ecart.model.Category;
import com.crud.ecart.model.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EcartServiceImpl implements CategoryService, BrandService, ProductService {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	BrandDao brandDao;

	@Autowired
	ProductDao productDao;

	@Override
	public String addNewCategory(Category category) {
		categoryDao.save(category);
		String method = "addNewCategory()";
		log.info(method + " called");
		return "===== New Category Added Succesfully =====";
	}

	@Override
	public String addNewListOfCategories(List<Category> categories) {
		categoryDao.saveAll(categories);
		String method = "addNewListOfCategories()";
		log.info(method + " called");
		return "==== New Categories Added Succesfully ====";
	}

	@Override
	public String updateCategory(Category category) {
		Category exisitngCategory = categoryDao.findById(category.getCategoryId()).orElse(null);
		exisitngCategory.setCategoryId(category.getCategoryId());
		exisitngCategory.setCategoryName(category.getCategoryName());
		categoryDao.save(category);
		String method = "updateCategory()";
		log.info(method + " called");
		return "==== Update Category Succesfully ====";
	}

	@Override
	public String deleteCategory(int categoryId) {
		categoryDao.deleteById(categoryId);
		String method = "deleteCategory()";
		log.info(method + " called");
		return "=== delete Category Succesfully ===";
	}

	@Override
	public Optional<Category> findById(int categoryId) {
		String method = "findById()";
		log.info(method + " called");
		return categoryDao.findById(categoryId);
	}

	@Override
	public List<Category> fetchAllCategories() {
		String method = "fetchAllCategories()";
		log.info(method + "called");
		return categoryDao.findAll();
	}

	@Override
	public Brand addNewBrand(Brand brand) {
		String method = "addNewBrand()";
		log.info(method + " called");
		return brandDao.save(brand);
	}

	@Override
	public String addNewListofBrands(List<Brand> brands) {
		brandDao.saveAll(brands);
		String method = "addNewListofBrands()";
		log.info(method + "called");

		return "=== New List of Brands Added Succesfully ===";
	}

	@Override
	public Brand updateBrand(Brand brand) {
		Brand existingBrand = brandDao.findById(brand.getBrandId()).orElse(brand);
		existingBrand.setBrandId(brand.getBrandId());
		existingBrand.setBrandName(brand.getBrandName());
		return brandDao.save(brand);
	}

	@Override
	public void deleteBrand(int brandId) {
		String method = "deleteBrand()";
		log.info(method + "called");
		brandDao.deleteById(brandId);
	}

	@Override
	public Optional<Brand> fetchById(int brandId) {
		String method="fetchById()";
		log.info(method+" called");
		return brandDao.findById(brandId);
	}

	@Override
	public List<Brand> fetchAllBrands() {
		String method="fetchAllBrands()";
		log.info(method+" called");
		return brandDao.findAll();
	}

	@Override
	public Product addNewProduct(Product product) {
		String method="addNewProduct()";
		log.info(method+" called");
		return productDao.save(product);
	}

	@Override
	public String addNewListOfProduct(List<Product> products) {
		productDao.saveAll(products);
		String method="addNewListOfProduct()";
		log.info(method+" called");
		return "=== Added new List of Products ===";
	}

	@Override
	public Product UpdateProduct(Product product) {
		Product existingProduct=productDao.findById(product.getProductId()).orElse(null);
		existingProduct.setProductId(product.getProductId());
		existingProduct.setProductName(product.getProductName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setProductDesc(product.getProductDesc());
		existingProduct.setBrand(product.getBrand());
		existingProduct.setCategory(product.getCategory());
		String method="UpdateProduct()";
		log.info(method+" called");
		return productDao.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		String method="deleteProduct()";
		log.info(method+" called");
		productDao.deleteById(productId);
	}

	@Override
	public List<Product> fetchAllProducts() {
		String method="fetchAllProducts()";
		log.info(method+" called");
		return productDao.findAll();
	}

	@Override
	public Optional<Product> fetchProductById(int productId) {
		String method="fetchProductById()";
		log.info(method+" called");
		return productDao.findById(productId);
	}

	@Override
	public List<Product> fetchProductByCategoryName(String categoryName) {
		String method="fetchProductByCategoryName()";
		log.info(method+" called");
		return productDao.findByCategoryName(categoryName);
	}

	@Override
	public List<Product> fetchProductByBrandName(String brandName) {
		
		return productDao.findByBrandName(brandName);
	}

	@Override
	public List<Product> filterbyPriceRange(double minPrice, double maxPrice) {
		
		return productDao.filterProductByPriceRange(minPrice,maxPrice);
	}

}
