package com.softuni.pathfinderproj.repositories;

import com.softuni.pathfinderproj.models.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity,Long> {

    Optional<RouteEntity> findByName(String name);
}
