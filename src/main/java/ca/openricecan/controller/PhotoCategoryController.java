package ca.openricecan.controller;

import ca.openricecan.model.entity.photo.PhotoCategoryEntity;
import ca.openricecan.service.photo.PhotoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/photo-category")
public class PhotoCategoryController {
    private final PhotoCategoryService photoCategoryService;

  @Autowired
  public PhotoCategoryController(PhotoCategoryService photoCategoryService) {
    this.photoCategoryService = photoCategoryService;
  }

  @GetMapping
  public Iterable<PhotoCategoryEntity> getPhotoCategoryList() {
    return photoCategoryService.getAllPhotoCategories();
  }

  @GetMapping(path = "{id}")
  public PhotoCategoryEntity getPhotoCategoryById(@PathVariable UUID id) {
    return photoCategoryService.getPhotoCategoryById(id);
  }

  @PostMapping
  public PhotoCategoryEntity addPhotoCategory(@RequestBody PhotoCategoryEntity photoCategoryEntity) {
    return photoCategoryService.addPhotoCategory(photoCategoryEntity);
  }

  @PutMapping(path = "{id}")
  public PhotoCategoryEntity editPhotoCategory(@PathVariable UUID id, @RequestBody PhotoCategoryEntity photoCategoryEntity) {
    return photoCategoryService.editPhotoCategory(id, photoCategoryEntity);
  }

  @DeleteMapping(path = "{id}")
  public PhotoCategoryEntity deletePhotoCategory(@PathVariable UUID id) {
    return photoCategoryService.deletePhotoCategory(id);
  }

}
