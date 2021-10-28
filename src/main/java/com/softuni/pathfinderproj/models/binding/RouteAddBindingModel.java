package com.softuni.pathfinderproj.models.binding;

import com.softuni.pathfinderproj.models.entity.enums.CategoryEnum;
import com.softuni.pathfinderproj.models.entity.enums.LevelEnum;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class RouteAddBindingModel {

    private MultipartFile gpxCoordinates;

    @NotNull
    private LevelEnum level;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    private String videoUrl;

    @NotNull
    @Size(min = 5)
    private String description;

    @NotNull
    private Set<CategoryEnum> categories;

    public RouteAddBindingModel(){

    }

    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteAddBindingModel setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteAddBindingModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteAddBindingModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    public RouteAddBindingModel setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
        return this;
    }
}
