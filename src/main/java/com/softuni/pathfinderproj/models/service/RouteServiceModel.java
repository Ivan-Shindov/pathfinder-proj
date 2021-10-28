package com.softuni.pathfinderproj.models.service;

import com.softuni.pathfinderproj.models.entity.CategoryEntity;
import com.softuni.pathfinderproj.models.entity.PictureEntity;
import com.softuni.pathfinderproj.models.entity.UserEntity;
import com.softuni.pathfinderproj.models.entity.enums.CategoryEnum;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

public class RouteServiceModel {

    private Long id;
    private String gpxCoordinates;

    private LevelEnum level;

    private String name;

    private UserEntity author;

    private String videoUrl;

    private String description;

    private Set<CategoryEnum> categories;

    private Set<PictureEntity> pictures;

    public RouteServiceModel() {

    }

    public Long getId() {
        return id;
    }

    public RouteServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteServiceModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteServiceModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteServiceModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteServiceModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    public RouteServiceModel setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
        return this;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public RouteServiceModel setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
