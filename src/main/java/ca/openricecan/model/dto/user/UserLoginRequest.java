package ca.openricecan.model.dto.user;

import lombok.Data;

// DTO=Data Transfer Object
// a design pattern used to transfer data between a service layer and a user interface layer
// Reducing network calls and simplifying interfaces and the hierarchies of a project
@Data
public class UserLoginRequest {
  private String email;
  private String password;
}
