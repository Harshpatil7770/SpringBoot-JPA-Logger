package com.crud.ecart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.ecart.model.Category;

public interface CategoryDao extends JpaRepository<Category,Integer>{

}
