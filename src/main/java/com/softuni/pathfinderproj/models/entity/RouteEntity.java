package com.softuni.pathfinderproj.models.entity;

import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity{

    @Column(columnDefinition = "LONGTEXT",name = "gpx_coordinates")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToOne
    private UserEntity author;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<CategoryEntity> categories;

    @OneToMany(mappedBy = "route",fetch = FetchType.EAGER)
    private Set<PictureEntity> pictures;

    public RouteEntity(){

    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteEntity setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteEntity setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteEntity setName(String name) {
        this.name = name;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public RouteEntity setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public RouteEntity setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
