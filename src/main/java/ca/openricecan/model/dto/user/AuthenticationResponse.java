package ca.openricecan.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// DTO=Data Transfer Object
// a design pattern used to transfer data between a service layer and a user interface layer
// Reducing network calls and simplifying interfaces and the hierarchies of a project
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
  private String token;
  private String message;
}
