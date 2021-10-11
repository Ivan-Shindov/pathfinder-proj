package com.softuni.pathfinderproj.services.impl;

import com.softuni.pathfinderproj.repositories.PictureRepository;
import com.softuni.pathfinderproj.services.PictureService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public List<String> findAllUrls() {
        return pictureRepository.findAllUrls();

    }
}
