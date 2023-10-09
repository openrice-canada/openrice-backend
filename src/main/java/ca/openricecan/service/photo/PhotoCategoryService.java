package ca.openricecan.service.photo;

import ca.openricecan.data.entity.photo.PhotoCategoryEntity;
import ca.openricecan.repository.photo.PhotoCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoCategoryService {
  private final PhotoCategoryRepository photoCategoryRepository;

  @Autowired
  public PhotoCategoryService(PhotoCategoryRepository photoCategoryRepository){
    this.photoCategoryRepository = photoCategoryRepository;
  }

  public Iterable<PhotoCategoryEntity> getAllPhotoCategories(){
    return photoCategoryRepository.findAll();
  }
}
