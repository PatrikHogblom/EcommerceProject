package com.ecommerceProject.ecom.services.admin.category;

import com.ecommerceProject.ecom.dto.CategoryDto;
import com.ecommerceProject.ecom.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createcategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
