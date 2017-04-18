package com.ionic.repository;

import org.springframework.data.repository.CrudRepository;

import com.ionic.model.Category;

public interface ICategoryRepository extends CrudRepository<Category, String> {

}
