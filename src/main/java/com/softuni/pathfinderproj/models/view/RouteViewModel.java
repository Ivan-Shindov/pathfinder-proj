package com.softuni.pathfinderproj.models.view;

public class RouteViewModel {

    private Long id;
    private String name;
    private String description;
    private String picture;

    public RouteViewModel(){

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

    public String getPicture() {
        return picture;
    }

    public RouteViewModel setPicture(String picture) {
        this.picture = picture;
        return this;
    }
}
