package com.softuni.pathfinderproj.services;

import com.softuni.pathfinderproj.models.entity.CategoryEntity;
import com.softuni.pathfinderproj.models.entity.enums.CategoryEnum;

public interface CategoryService {
    CategoryEntity findByCategoryName(CategoryEnum categoryEnum);
}
