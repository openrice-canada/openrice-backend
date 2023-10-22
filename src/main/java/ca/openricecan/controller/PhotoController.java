package ca.openricecan.controller;

import ca.openricecan.model.entity.photo.PhotoEntity;
import ca.openricecan.service.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "photo")
public class PhotoController {
    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public Iterable<PhotoEntity> getPhotoList() {
        return photoService.getAllPhotos();
    }

    @GetMapping(path = "{id}")
    public PhotoEntity getPhotoById(@PathVariable UUID id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping
    public PhotoEntity addPhoto(@RequestBody PhotoEntity photoEntity) {
        return photoService.addPhoto(photoEntity);
    }

    @PutMapping(path = "{id}")
    public PhotoEntity editPhoto(@PathVariable UUID id, @RequestBody PhotoEntity photoEntity) {
        return photoService.editPhoto(id, photoEntity);
    }

    @DeleteMapping(path = "{id}")
    public PhotoEntity deletePhoto(@PathVariable UUID id) {
        return photoService.deletePhoto(id);
    }
}
