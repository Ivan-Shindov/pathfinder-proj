package com.softuni.pathfinderproj.repositories;

import com.softuni.pathfinderproj.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


}
