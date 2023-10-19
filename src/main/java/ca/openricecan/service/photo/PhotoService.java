package ca.openricecan.service.photo;

import ca.openricecan.model.entity.photo.PhotoEntity;
import ca.openricecan.repository.photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
  private final PhotoRepository photoRepository;

  @Autowired
  public PhotoService(PhotoRepository photoRepository){
    this.photoRepository = photoRepository;
  }

  public Iterable<PhotoEntity> getAllPhotos(){
    return photoRepository.findAll();
  }
}
