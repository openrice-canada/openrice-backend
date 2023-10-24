package ca.openricecan.controller;

import ca.openricecan.model.entity.user.UserEntity;
import ca.openricecan.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public Iterable<UserEntity> getUserList() {
    return userService.getAllUsers();
  }

  @GetMapping(path = "{id}")
  public UserEntity getUserById(@PathVariable UUID id) {
    return userService.getUserById(id);
  }

  @PostMapping
  public UserEntity addUser(@RequestBody UserEntity userEntity) {
    return userService.addUser(userEntity);
  }

  @PutMapping(path = "{id}")
  public UserEntity editUser(@PathVariable UUID id, @RequestBody UserEntity userEntity) {
    return userService.editUser(id, userEntity);
  }

  @DeleteMapping(path = "{id}")
  public UserEntity deleteUser(@PathVariable UUID id) {
    return userService.deleteUser(id);
  }
}
