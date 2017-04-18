package com.ionic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ionic.delegate.CategoryControllerDelegate;
import com.ionic.model.Category;

@RestController
@RequestMapping("api/v1.0")
public class CategoryController {
    
    @Autowired
    CategoryControllerDelegate categoryDelegate;
    
    @RequestMapping(path = "categories", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public List<Category> retriveCategories() {
        try{
            return categoryDelegate.getAllCategories();
        }catch(Exception e){
            throw e;
        }   
    }
}
