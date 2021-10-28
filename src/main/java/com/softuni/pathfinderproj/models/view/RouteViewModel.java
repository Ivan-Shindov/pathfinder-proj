package com.softuni.pathfinderproj.models.view;

import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;

import java.util.List;
import java.util.Set;

public class RouteViewModel {

    private Long id;
    private String name;
    private String description;
    private List<String> pictures;
    private String authorName;
    private String videoUrl;
    private Double distance;
    private LevelEnum level;


    public RouteViewModel(){

    }



    public String getAuthorName() {
        return authorName;
    }

    public RouteViewModel setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Double getDistance() {
        return distance;
    }

    public RouteViewModel setDistance(Double distance) {
        this.distance = distance;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RouteViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public RouteViewModel setPictures(List<String> pictures) {
        this.pictures = pictures;
        return this;
    }
}
