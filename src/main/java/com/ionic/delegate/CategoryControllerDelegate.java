package com.ionic.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ionic.model.Category;
import com.ionic.repository.ICategoryRepository;

@Component
public class CategoryControllerDelegate {

    @Autowired
    ICategoryRepository categoryRepository;
    
    
    public List<Category> getAllCategories(){
        Iterable<Category> catagories = categoryRepository.findAll();
        List<Category> categoryList = new ArrayList<>();
        catagories.forEach(categoryList::add);
        return categoryList;
    }

}
