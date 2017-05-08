package com.ucbcba.tallerprogra.Services;


import com.ucbcba.tallerprogra.Entities.Category;

/**
 * Created by da_20 on 26/4/2017.
 */
public interface CategoryService {

    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}
