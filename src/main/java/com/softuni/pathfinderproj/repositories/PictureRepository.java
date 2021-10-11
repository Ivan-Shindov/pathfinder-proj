package com.softuni.pathfinderproj.repositories;

import com.softuni.pathfinderproj.models.entity.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends JpaRepository<PictureEntity,Long> {


    @Query("SELECT p.url FROM PictureEntity p")
    List<String> findAllUrls();
}

