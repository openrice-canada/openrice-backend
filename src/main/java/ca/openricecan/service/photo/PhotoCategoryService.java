package ca.openricecan.service.photo;

import ca.openricecan.model.entity.photo.PhotoCategoryEntity;
import ca.openricecan.repository.photo.PhotoCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhotoCategoryService {
    private final PhotoCategoryRepository photoCategoryRepository;

    @Autowired
    public PhotoCategoryService(PhotoCategoryRepository photoCategoryRepository) {
        this.photoCategoryRepository = photoCategoryRepository;
    }

    public Iterable<PhotoCategoryEntity> getAllPhotoCategories() {
        return photoCategoryRepository.findAll();
    }

    public PhotoCategoryEntity getPhotoCategoryById(UUID id) {
        return photoCategoryRepository.findById(id).orElse(null);
    }

    public PhotoCategoryEntity addPhotoCategory(PhotoCategoryEntity photoCategoryEntity) {
        return photoCategoryRepository.save(photoCategoryEntity);
    }

    public PhotoCategoryEntity editPhotoCategory(UUID id, PhotoCategoryEntity photoCategoryEntity) {
        return photoCategoryRepository.findById(id).map(photoCategory -> {
            photoCategoryEntity.setPhotoCategoryId(id);
            return photoCategoryRepository.save(photoCategoryEntity);
        }).orElse(null);
    }

    public PhotoCategoryEntity deletePhotoCategory(UUID id) {
        return photoCategoryRepository.findById(id).map(photoCategory -> {
            photoCategory.setActive(false);
            return photoCategoryRepository.save(photoCategory);
        }).orElse(null);
    }
}
