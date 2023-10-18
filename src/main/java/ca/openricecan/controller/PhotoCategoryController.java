package ca.openricecan.controller;

import ca.openricecan.data.entity.photo.PhotoCategoryEntity;
import ca.openricecan.service.photo.PhotoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/photo-category")
public class PhotoCategoryController {
  private final PhotoCategoryService photoCategoryService;

  @Autowired
  public PhotoCategoryController(PhotoCategoryService photoCategoryService){
    this.photoCategoryService = photoCategoryService;
  }

  @GetMapping
  public Iterable<PhotoCategoryEntity> getPhotoCategoryList(){
    return photoCategoryService.getAllPhotoCategories();
  }
}