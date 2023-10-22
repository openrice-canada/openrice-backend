package ca.openricecan.service.photo;

import ca.openricecan.model.entity.photo.PhotoEntity;
import ca.openricecan.repository.photo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<PhotoEntity> getAllPhotos() {
        return photoRepository.findAll();
    }

    public PhotoEntity getPhotoById(UUID id) {
        return photoRepository.findById(id).orElse(null);
    }

    public PhotoEntity addPhoto(PhotoEntity photoEntity) {
        return photoRepository.save(photoEntity);
    }

    public PhotoEntity editPhoto(UUID id, PhotoEntity photoEntity) {
        return photoRepository.findById(id).map(photo -> {
            photoEntity.setPhotoId(id);
            return photoRepository.save(photoEntity);
        }).orElse(null);
    }

    public PhotoEntity deletePhoto(UUID id) {
        return photoRepository.findById(id).map(photo -> {
            photo.setActive(false);
            return photoRepository.save(photo);
        }).orElse(null);
    }
}
