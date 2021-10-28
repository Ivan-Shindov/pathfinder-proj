package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.models.entity.CategoryEntity;
import com.softuni.pathfinderproj.models.entity.enums.CategoryEnum;
import com.softuni.pathfinderproj.repositories.CategoryRepository;
import com.softuni.pathfinderproj.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryEntity findByCategoryName(CategoryEnum categoryEnum) {

       return categoryRepository.findByName(categoryEnum).orElse(null);
    }
}
