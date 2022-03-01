package com.crud.ecart.service;

import java.util.List;
import java.util.Optional;

import com.crud.ecart.model.Brand;

public interface BrandService {

	Brand addNewBrand(Brand brand);
	
	String addNewListofBrands(List<Brand> brands);
	
	Brand updateBrand(Brand brand);
	
	void deleteBrand(int brandId);
	
	Optional<Brand> fetchById(int brandId);
	
	List<Brand> fetchAllBrands();
}
