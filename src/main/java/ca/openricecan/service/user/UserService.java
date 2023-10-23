package ca.openricecan.service.user;

import ca.openricecan.model.entity.user.UserEntity;
import ca.openricecan.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity addUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity editUser(UUID id, UserEntity userEntity) {
        return userRepository.findById(id).map(user -> {
            userEntity.setUserId(id);
            return userRepository.save(userEntity);
        }).orElse(null);
    }

    public UserEntity deleteUser(UUID id) {
        return userRepository.findById(id).map(user -> {
            user.setActive(false);
            return userRepository.save(user);
        }).orElse(null);
    }
}
