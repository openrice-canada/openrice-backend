package ca.openricecan.controller.photo;

import ca.openricecan.data.entity.photo.PhotoEntity;
import ca.openricecan.service.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "photo")
public class PhotoController {
  private final PhotoService photoService;

  @Autowired
  public PhotoController(PhotoService photoService){
    this.photoService = photoService;
  }

  @GetMapping
  public Iterable<PhotoEntity> getPhotoList(){
    return photoService.getAllPhotos();
  }
}
