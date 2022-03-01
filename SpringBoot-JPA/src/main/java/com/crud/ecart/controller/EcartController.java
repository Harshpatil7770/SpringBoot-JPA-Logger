package com.crud.ecart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.ecart.model.Brand;
import com.crud.ecart.model.Category;
import com.crud.ecart.model.Product;
import com.crud.ecart.service.BrandService;
import com.crud.ecart.service.CategoryService;
import com.crud.ecart.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/ecart")
@Slf4j
public class EcartController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	BrandService brandService;
	
	@Autowired
	ProductService productService;

	@PostMapping("/addnewcategory")
	public String addNewCategory(@RequestBody Category category) {
		categoryService.addNewCategory(category);
		String method = "addNewCategory()";
		log.info(method + " called()");
		return "==== New Category Added Succesfully ==== CATEGORY_ID::" + category.getCategoryId();

	}

	@PostMapping("/addnew/listofcategories")
	public String addNewListOfCategories(@RequestBody List<Category> categories) {
		categoryService.addNewListOfCategories(categories);
		String method = "addNewListOfCategories()";
		log.info(method + " called()");
		return "=== New List Of Categories Added Succesfully ===";
	}

	@PutMapping("/update/category")
	public String updateExisitngCategory(@RequestBody Category category) {
		categoryService.updateCategory(category);
		String method = "updateExisitngCategory()";
		log.info(method + " called");
		return "=== Update Category Succesfully ===  CATEGORY_ID::" + category.getCategoryId();
	}

	@DeleteMapping("/delete/category/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {
		categoryService.deleteCategory(categoryId);
		String method = "deleteCategory()";
		log.info(method + " called");
		return "=== Delete Category Succesfully === CATEGORY_ID::" + categoryId;
	}

	@GetMapping("/fetch/{categoryId}")
	public Optional<Category> findCategoryById(@PathVariable int categoryId) {
		String method = "findCategoryById()";
		log.info(method + " called");
		return categoryService.findById(categoryId);
	}

	@GetMapping("/fetch/allcategories")
	public List<Category> fetchAllCategories() {
		String method = "fetchAllCategories()";
		log.info(method + " called");
		return categoryService.fetchAllCategories();
	}

	@PostMapping("/addnewbrand")
	public String addNewBrand(@RequestBody Brand brand) {
		String method = "addNewBrand()";
		log.info(method + " called");
		brandService.addNewBrand(brand);
		return "=== New Brand Added Succesfully === BRAND_ID ::" + brand.getBrandId();
	}

	@PostMapping("/add/listofbrands")
	public String addNewListofBrands(@RequestBody List<Brand> brands) {
		brandService.addNewListofBrands(brands);
		String method = "addNewListofBrands()";
		log.info(method + "called()");
		return "=== New List of Brands Added Succesfully ===";

	}

	@PutMapping("/updateBrand")
	public String updateBrand(@RequestBody Brand brand) {
		brandService.updateBrand(brand);
		String method = "updateBrand()";
		log.info(method + "called");
		return "=== Update Brand Succesufully ===\nBRNAD_ID:: " + brand.getBrandId() + " BRNAD_NAME:: "
				+ brand.getBrandName();
	}

	@DeleteMapping("/deleteById/{brandId}")
	public String deleteById(@PathVariable int brandId) {
		brandService.deleteBrand(brandId);
		String method="deleteById()";
		log.info(method+" called");
		return "=== Delete Brand Succesfully ===\nBrand_Id:: "+brandId;
	}
	
	@GetMapping("/findById/{brandId}")
	public Optional<Brand> findById(@PathVariable int brandId){
		String method="findById()";
		log.info(method+" called");
		return brandService.fetchById(brandId);
	}
	
	@GetMapping("/fetchAllBrands")
	public List<Brand> fetchAllBrands(){
		String method="fetchAllBrands()";
		log.info(method+" called");
		return brandService.fetchAllBrands();	
	}
	
	@PostMapping("/addnewproduct")
	public String addNewProduct(@RequestBody Product product) {
		 productService.addNewProduct(product);	
		 String method="addNewProduct()";
		 log.info(method+" called");
		 return "=== New Product Added Sucesfully ===\n Product Id::"+product.getProductId();
	}
	
	@PostMapping("/add/listofproducts")
	public String addNewListOfProduct(@RequestBody List<Product> products) {
		String method="addNeListOfProduct()";
		log.info(method+" called");
		 productService.addNewListOfProduct(products);
		return "=== List of New Product Added Succesfully ===";
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		productService.UpdateProduct(product);
		return "==== Update Product Succesfully === PRODUCT_ID :"+product.getProductId();
	}
	
	@DeleteMapping("delete/product/{productId}")
	public String deleteProductById(@PathVariable int productId) {
		String method="deleteProductById()";
		log.info(method+" called");
		productService.deleteProduct(productId);
		return "=== Delete Product Succesfully === Product ID:: "+productId;
	}
	

	@GetMapping("/fetchall/products")
	public List<Product> fetchAllProduct(){
		String method="fetchAllProduct()";
		log.info(method+" called");
		return productService.fetchAllProducts();
		
	}
	
	@GetMapping("/filter/product/{productId}")
	public Optional<Product> findProductById(@PathVariable int productId){
		String method="findProductById()";
		log.info(method+" called");
		return productService.fetchProductById(productId);
	}
	
	@GetMapping("/filter/product/categoryname/{categoryName}")
	public List<Product> filterByCategoryName(@PathVariable String categoryName){
		String method="filterByCategoryName()";
		log.info(method+" called");
		return productService.fetchProductByCategoryName(categoryName);
	}
	
	@GetMapping("/filter/product/brandname/{brandName}")
	public List<Product> filterByBrandName(@PathVariable String brandName){
		String method="filterByBrandName()";
		log.info(method+" called");
		return productService.fetchProductByBrandName(brandName);
	}
	
	@GetMapping("filter/product/{minPrice}/{maxPrice}")
	public List<Product> filterProductByPriceRange(@PathVariable double minPrice,@PathVariable double maxPrice){
		String method="filterProductByPriceRange()";
		log.info(method+" called");
		return productService.filterbyPriceRange(minPrice, maxPrice);
	}
}
