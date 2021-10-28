package com.softuni.pathfinderproj.repositories;

import com.softuni.pathfinderproj.models.entity.CategoryEntity;
import com.softuni.pathfinderproj.models.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<CategoryEntity> findByName(CategoryEnum categoryEnum);
}
